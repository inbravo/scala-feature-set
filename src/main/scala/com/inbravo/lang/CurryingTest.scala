package com.inbravo.lang

/**
 * amit.dixit
 */
object CurryingTest extends App {

  /* A method using currying */
  def curriedSum(x: Int)(y: Int) = x + y

  println("curriedSum: " + curriedSum(1)(2))

  /* This is what the 'curriedSum' function actually does. Returns function value (x: Int) Int => Int */
  def first(x: Int) = (y: Int) => x + y

  /* Applying 1 to the first function yields the second function */
  val second = first(1)

  /* Applying 2 to the second function yields the final result */
  println("second: " + second(2))
}