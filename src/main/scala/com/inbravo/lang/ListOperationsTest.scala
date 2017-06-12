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

  /* A sample method to understand how 'tableswitch' optimization works */
  def unannotated(x: Int) = x match {

    /* Mappings of integer values to ordinal string */
    case 1 => "One"
    case 2 => "Two!"
    case z => z + "?"
  }
}