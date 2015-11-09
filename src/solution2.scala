// パス: lx04/src/solution2.scala
// エンコーディング: UTF8

package puzzle

/**
 * パズルの別解．コードの短さに驚愕するかもしれないが慌ててはいけない．
 * Solution1.satisfyを借用している点が大きい．ただし，genCheck自体はイテレータを
 * 用いることでかなり簡素化されていることは事実だ．
 **/
object Solution2 extends Solution {

  def name = "Solution 2"

  def genCheck(): List[List[Int]] = {
    val range = List.range(0, 9)
    for (x1 <- range; x2 <- range; x3 <- range; x4 <- range
         if Solution1.satisfy(List(x1, x2, x3, x4)))
      yield List(x1, x2, x3, x4)
  }

  def solve(): List[List[Int]] = genCheck()
}
