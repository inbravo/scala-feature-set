package com.inbravo.random
/**
 * amit.dixit
 */
final class XFROne {

  /* Local variables */
  var count: Int = 0
  var sum_tmp_0: Int = 0
  var col_name: String = ""
  var col_value: String = ""

  /* Initialize */
  def initialize(in: XFROne) = this.sum_tmp_0 = 0

  /* Do increments */
  def rollup(temp: XFROne, in: XFROne) = this.sum_tmp_0 = temp.sum_tmp_0 + in.count

  /* Finalize */
  def finalize(temp: XFROne, in: XFROne) = {

    this.col_name = in.col_name
    this.col_value = in.col_value
    this.count = temp.sum_tmp_0
  }

  def print() = println("col_name : " + this.col_name + ", col_value: " + this.col_value + ", count : " + this.count)
}

object XFROneTest extends App {

  /* Create XFRs */
  val in: XFROne = new XFROne;
  in.count = (10)
  in.col_name = ("ColumnIn")
  in.col_value = ("ColumnIn")

  val temp: XFROne = new XFROne;
  temp.count = (20)
  temp.col_name = ("ColumnTemp")
  temp.col_value = ("ColumnTemp")

  val out: XFROne = new XFROne;

  /* Initialize */
  out.initialize(in)

  /* Do function in loop */
  for (i <- 1 to 10) out.rollup(temp, in)

  out.finalize(temp, in)

  /* Output should include count from 'temp' XFROne and rest of values from 'in' XFROne */
  out.print()
}
