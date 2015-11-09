// パス: lx04/src/main.scala
// エンコーディング: UTF8

package puzzle

object Main {

  def main(arguments : Array[String]) {
    List(Solution1, Solution2).foreach((solution: Solution) => {
      println(solution.name)
      solution.solve().foreach(println)
    })
  }
}
