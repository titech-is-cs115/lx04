// パス: lx04/src/solution1.scala
// エンコーディング: UTF8

package puzzle

object Solution1 extends Solution {

  def name = "Solution 1"

  /**
   * 数列(nums)中に出現するnの個数を勘定する．
   * c(2)(List(1, 2, 3, 2, 1, 4)) => 2
   * c(3)(List(1, 2, 3, 2, 1, 4)) => 1
   * c(0)(List(1, 2, 3, 2, 1, 4)) => 0
   *
   * lx03.Puzzleでは再帰的関数を用意した．ここではList.foldLeftを用いている．
   **/
  def c(n: Int)(nums: List[Int]): Int = {
    nums.foldLeft (0) ((s, x) => s + (if (x == n) 1 else 0))
  }

  /**
   * 数列(nums)中に出現する1, 2, 3, その他の個数を勘定する．
   * counts(List(1, 2, 3, 2, 1, 4)) => List(2, 2, 1, 1)
   **/
  def counts(nums: List[Int]): List[Int] = {
    val (c1, c2, c3) = (c(1)(nums), c(2)(nums), c(3)(nums))
    val c_ = nums.length - (c1 + c2 + c3)
    List(c1, c2, c3, c_)
  }

  /**
   * パズルの紙面に出現する1, 2, 3, その他の個数を勘定した結果
   **/
  val countsOnPaper = counts(List(1, 2, 3, 1, 3))

  /**
   * パズルの期待する条件は，パズルを穴埋めしたときの1, 2, 3, その他の個数が
   * 穴埋めした数と一致すること．つまり，以下のようなことが成立すること
   *   counts(candidate) + countsOnPaper = candidate
   **/
  def satisfy(candidate: List[Int]): Boolean = {
    counts(candidate).zip(countsOnPaper).map(p => p._1 + p._2) == candidate
  }

  /**
   * ある穴埋めの可能性をすべて生成し，satisfy条件に合致するものを収集する．
   * (x1, x2, x3, x4): x1, x2, x3, x4 in [0, 9] を生成するために，[0, 10^4-1]
   * の範囲の非負整数の十進表記の下4桁をそれぞれx1, x2, x3, x4としている．
   **/
  def N = 10 * 10 * 10 * 10
  def genCheck(i: Int, answers: List[List[Int]]): List[List[Int]] = {
    if (i >= N) answers
    else {
      val candidate = List(i / 1000, (i / 100) % 10, (i / 10) % 10, i % 10)
      if (satisfy(candidate)) genCheck(i + 1, candidate :: answers)
      else genCheck(i + 1, answers)
    }
  }

  def solve(): List[List[Int]] = {
    genCheck(0, Nil)
  }
}
