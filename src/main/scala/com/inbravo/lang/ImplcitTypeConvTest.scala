package com.inbravo.lang
/**
 * amit.dixit
 */
object ImplcitTypeConvTest {

  /* Implicit type conversion */
  implicit def array2string[T](x: Array[T]) = x.toString

  def main(): Unit = {

  }
}