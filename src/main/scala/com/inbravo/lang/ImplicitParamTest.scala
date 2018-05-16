package com.inbravo.lang

/**
 * An example to understand implicit parameters work
 * amit.dixit
 */
object ImplicitParamTest {

  /* Compiler will bind 'implicit val value = 2' to the context in which they are called */
  implicit val value = 2

  /* Method 'square' call does not provides any parameter of type Int as desired in definition */
  /* If variable is 'implicit', compiler will look for a variable of type Int in the implicit scope */
  /* Compiler will find 'implicit val value = 2' and will pass value '2' while calling 'square' method */
  def main(args: Array[String]): Unit = println(square)

  /* The final parameter list on a method can be marked implicit, which means the values will be taken from the context in which they are called */
  def square(implicit value: Int) = value * value
}