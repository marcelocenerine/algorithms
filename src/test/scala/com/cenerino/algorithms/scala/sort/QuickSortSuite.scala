package com.cenerino.algorithms.scala.sort

import com.cenerino.algorithms.scala.sort.QuickSort._
import org.scalatest.FunSuite

class QuickSortSuite extends FunSuite {

  test("sort distinct elements") {
    val result = sort(Array(10, 5, 9, 1, 3, 0, -1, 5, 8, 15, 4, 7, -6))

    result === Array(-6, -1, 0, 1, 3, 4, 5, 5, 7, 8, 9, 10, 15)
  }

  test("sort duplicate elements") {
    val result = sort(Array(10, 4, 9, 1, 9, 0, 9, 5, 4))

    result === Array(0, 1, 4, 4, 5, 9, 9, 9, 10)
  }

  test("sort array with single element") {
    sort(Array(1)) === Array(1)
  }

  test("sort empty array") {
    sort(Array.empty) === Array.emptyIntArray
  }
}
