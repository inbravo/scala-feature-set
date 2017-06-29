package com.inbravo.lang

/**
 * 	How a Partial Applied Function can be used in Scala
 *
 * 	amit.dixit
 */
object PartialAppliedFuncTest extends App {

  def aFunction(one: Int, two: Int, three: Int) = one + two + three

  /* A completly applied function */
  val returnedValue = aFunction(1, 2, 3)
  println(returnedValue)

  /* A partial applied function */
  val partialAppliedFunc = aFunction(1, _: Int, _: Int)
  println(partialAppliedFunc)

  /* A partial applied function */
  val secondPartialAppliedFunc = aFunction(1, 2, _: Int)
  println(secondPartialAppliedFunc)

  /* A partial applied function */
  val thirdPartialAppliedFunc = aFunction(1, _: Int, 3)
  println(thirdPartialAppliedFunc)

  /* Now apply all these functions on more variables */
  println(partialAppliedFunc(2, 3))
  println(secondPartialAppliedFunc(3))
  println(thirdPartialAppliedFunc(2))
}