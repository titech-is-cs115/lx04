package puzzle

import Main._
import Solution1._
import org.scalatest._

class Solution1Test extends FunSuite {

  test("countN tests") {
    countN(2)(List(1, 2, 3, 2, 1, 4)) == (2)
    countN(3)(List(1, 2, 3, 2, 1, 4)) == (1)
    countN(1)(List(1, 1, 1, 1, 1, 1, 4)) == (6)
  }

  test("counts tests") {
    counts(List(1, 2, 3, 2, 1, 4)) == (List(2, 2, 1, 1))
  }

  test("solve tests") {
    solve() == (List(List(4,1,3,1)))
  }
}
