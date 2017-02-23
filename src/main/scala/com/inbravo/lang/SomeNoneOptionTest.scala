package com.inbravo.lang

/**
 * amit.dixit
 *
 * How Scala avoids NullPointerException
 */
object SomeNoneOptionTest {

  def main(args: Array[String]): Unit = {

    /* 'Some' and 'None' values */
    val someValue: Option[String] = Some("1")
    val noneValue: Option[String] = None

    println(someValue.isDefined) /* Returns true */
    println(someValue.isEmpty) /* Returns false */

    println(noneValue.isDefined) /* Returns false */
    println(noneValue.isEmpty) /* Returns true */

    val someNumericValue = someValue match {
      case Some(value) => value
      case None        => 0.0
    }

    println(someNumericValue)

    val someNoneValue = noneValue match {
      case Some(value) => value
      case None        => 0.0
    }

    println(someNoneValue)
  }
}