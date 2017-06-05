package com.inbravo.lang

/**
 * Program shows various operations on List class
 * amit.dixit
 */
object ListOperationsTest {

  /* Average method uses left folding technique */
  def avg(values: List[Double]) = {

    val sum = values.foldLeft(0.0) { _ + _ }
    sum / values.size.toDouble
  }
}