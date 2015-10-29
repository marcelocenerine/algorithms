package com.cenerino.algorithms.scala.sort

import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class QuickSortTest extends FunSuite {

  test("sort distinct elements") {
    val result = QuickSort.sort(Array(10, 5, 9, 1, 3, 0, -1, 5, 8, 15, 4, 7, -6))

    assertThat(result, is(Array(-6, -1, 0, 1, 3, 4, 5, 5, 7, 8, 9, 10, 15)))
  }

  test("sort duplicate elements") {
    val result = QuickSort.sort(Array(10, 4, 9, 1, 9, 0, 9, 5, 4))

    assertThat(result, is(Array(0, 1, 4, 4, 5, 9, 9, 9, 10)))
  }

  test("sort array with single element") {
    val result = QuickSort.sort(Array(1))

    assertThat(result, is(Array(1)))
  }

  test("sort empty array") {
    val result = QuickSort.sort(Array.empty)

    assertThat(result, is(Array.emptyIntArray))
  }
}
