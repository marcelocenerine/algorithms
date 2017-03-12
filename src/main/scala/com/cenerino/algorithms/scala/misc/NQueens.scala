package com.cenerino.algorithms.scala.misc

object NQueens {

  type Pos = (Int, Int)
  type Solution = List[Pos]

  def solve(n: Int): List[Solution] = {
    def placeQueens(k: Int): List[Solution] =
      if (k == 0) List(Nil)
      else for {
        queens <- placeQueens(k - 1)
        column <- 1 to n
        queen = (k, column)
        if isSafe(queen, queens)
      } yield queen :: queens

    def isSafe(queen: Pos, queens: Solution) = queens forall (!inCheck(_, queen))

    def inCheck(q1: Pos, q2: Pos) = {
      val (row1, col1) = q1
      val (row2, col2) = q2
      col1 == col2 || (row1 - row2).abs == (col1 - col2).abs
    }

    require(n >= 0)
    placeQueens(n)
  }
}
