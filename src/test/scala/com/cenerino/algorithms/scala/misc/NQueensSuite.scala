package com.cenerino.algorithms.scala.misc

import org.scalatest.FunSuite

class NQueensSuite extends FunSuite {

  test("solve with 0 queens") {
    NQueens.solve(0) === List(Nil)
  }

  test("solve with negative number of queens") {
    intercept[IllegalArgumentException] {
      NQueens.solve(-1)
    }
  }

  test("solve with 1 queen") {
    NQueens.solve(1) === List(List((1, 1)))
  }

  test("solve with multiple queens") {
    val expectedSolutions = Set((1, 2), (2, 4), (3, 1), (4, 3)) :: Set((1, 3), (2, 1), (3, 4), (4, 2)) :: Nil
    val solutions = NQueens.solve(4)

    solutions.size === expectedSolutions.size
    solutions.foreach(sol => assert(expectedSolutions.contains(sol.toSet)))
  }
}
