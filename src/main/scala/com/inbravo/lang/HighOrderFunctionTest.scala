package com.inbravo.lang

/**
 * High Order Function : These are functions that take other functions as parameters, or whose result is a function
 *
 * amit.dixit
 */
object HighOrderFunctionTest extends App {

  /* Method `apply` has two params: function `f` & value `v` and it applies `f` to `v` */
  def apply(f: Int => String, v: Int) = f(v)

  /* Create a new 'Decorator' object */
  val decorator = new Decorator("[", "]")

  /* Pass 'decorator.layout' to 'apply' */
  val layoutOutput = apply(decorator.layout, 7)

  println(layoutOutput)
}

class Decorator(left: String, right: String) {

  /* Method is bound to type 'A' */
  def layout[A](x: A) = left + x.toString() + right
}