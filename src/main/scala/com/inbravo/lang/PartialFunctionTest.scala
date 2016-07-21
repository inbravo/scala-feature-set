package com.inbravo.lang

/**
 * 	amit.dixit
 *  https://mbonaci.github.io/scala
 */
object PartialFunctionTest extends App {

  def sum(a: Int, b: Int, c: Int) = a + b + c

  /* Initialize to default value */
  var n: Int = _

  /* '_' is a placeholder for the entire parameter list */
  val sumOfAll = sum _

  println("sumOfAll: " + sumOfAll(1, 2, 3))

  /* They are called partially applied functions because you can do this */
  val sumOfOne = sum(1, _: Int, 3)

  println("sumOfOne: " + sumOfOne(1))

  /* They are called partially applied functions because you can do this */
  val sumOfTwo = sum(1, _: Int, _: Int)

  println("sumOfTwo: " + sumOfTwo(1, 2))

  def curriedSum(x: Int)(y: Int) = x + y

  println("curriedSum: " + curriedSum(1)(2))

  /* This is what the 'curriedSum' function actually does. Returns function value (x: Int) Int => Int */
  def first(x: Int) = (y: Int) => x + y

  /* Applying 1 to the first function yields the second function */
  val second = first(1)

  /* Applying 2 to the second function yields the final result */
  println("second: " + second(2))

  /* You can directly give parameter names and values */
  println("sum: " + sum(c = 10, b = 20, a = 30))
}