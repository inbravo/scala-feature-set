package com.inbravo.lang

/**
 * 	How a Partial Applied Function can be used in Scala
 *
 * 	amit.dixit
 */
object PartialAppliedFuncTest extends App {

  def sum(one: Int, two: Int, three: Int) = one + two + three

  /* A completly applied function */
  val returnedValue = sum(1, 2, 3)
  println(returnedValue)

  /* A partial applied function */
  val partialAppliedFunc = sum(1, _: Int, _: Int)
  println(partialAppliedFunc)

  /* A partial applied function */
  val secondPartialAppliedFunc = sum(1, 2, _: Int)
  println(secondPartialAppliedFunc)

  /* A partial applied function */
  val thirdPartialAppliedFunc = sum(1, _: Int, 3)
  println(thirdPartialAppliedFunc)

  /* '_' is a placeholder for the entire parameter list */
  val fourthPartialAppliedFunc = sum _
  println(fourthPartialAppliedFunc)

  /* Now apply all these functions on more variables */
  println(partialAppliedFunc(2, 3))
  println(secondPartialAppliedFunc(3))
  println(thirdPartialAppliedFunc(2))
  println(fourthPartialAppliedFunc(1, 2, 3))
}