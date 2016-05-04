package com.inbravo.lang
/**
 * amit.dixit
 */
object TupleTest {

  def main(args: Array[String]) {

    /* Create a new Tuple */
    val t = (4, 3, 2, 1)

    val sum = t._1 + t._2 + t._3 + t._4

    println("Tuple: " + t.getClass)
    println("Sum of elements: " + sum)
  }
}