package com.inbravo.lang

/**
 * Methods may define multiple parameter lists
 * When a method is called with a fewer number of parameter lists, then this will yield a function taking the missing parameter lists as its arguments
 *
 * Currying is named after Haskell Curry, an American mathematician. He is known for his work in combinatory logic.
 * Currying is a means of transforming a function that takes more than one argument into a chain of calls to functions, each of which takes a single argument
 *
 * amit.dixit
 */
object CurryingTest extends App {

  /* 	A method without currying	*/
  def sum(x: Int, y: Int) = x + y

  /* 	A method using currying	*/
  /* 	Redefines the sum method so that it takes only a single 'Int' as a parameter and returns a 'Clozure' as a result	*/
  /*	Then main program calls this 'Clozure', and passes second parameter */
  /*	This method will yield a function (called Clozure), taking the missing parameter lists as its arguments */
  def curriedSum(x: Int) = { (y: Int) => x + y }

  /* 	Another improved method using currying	*/
  def anotherCurriedSum(x: Int)(y: Int) = x + y

  /* Two values */
  val x = 1
  val y = 2

  /* Clarification how 'Clozure', returned by 'curriedSum' works */
  val curriedSumClozure = curriedSum(x)
  val anotherCurriedSumClozure = curriedSum(y)

  println("curriedSumClozure: " + curriedSumClozure)

  println("Simple Sum : " + sum(x, x) + " & CurriedSum: " + curriedSumClozure(x) + " & anotherCurriedSum: " + anotherCurriedSum(x)(x))
  println("Simple Sum : " + sum(y, y) + " & CurriedSum: " + anotherCurriedSumClozure(y) + " & anotherCurriedSum: " + anotherCurriedSum(y)(y))
}