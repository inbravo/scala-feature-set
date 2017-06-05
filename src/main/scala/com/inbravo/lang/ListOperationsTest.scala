package com.inbravo.lang

/**
 *
 */
object ListOperationsTest {

  /* Average method uses left folding technique */
  def avg(values: List[Double]) = {
    
    val sum = values.foldLeft(0.0) { _ + _ }
    sum / values.size.toDouble
  }
}