package com.inbravo.lang

/**
 *
 */
object ImplicitParamTest {

  implicit val value = 2

  /* Square will implicitly take value from previously defined statement */
  def main(args: Array[String]): Unit = println(square)

  def square(implicit value: Int) = value * value
}