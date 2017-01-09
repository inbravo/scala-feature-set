package com.inbravo.lang

/**
 * The + - * / % operators do their usual job, as do the bit operators & | ^ >> <<. There
 * is just one surprising aspect: These operators are actually methods
 *
 * amit.dixit
 */
object OperatorsAreMethods {

  def main(args: Array[String]): Unit = {

    val a = "a"
    val b = "b"

    /* '+' is nothing but just a method implemented in String class */
    println(a.+(b))

    /* a + b == a.+(b) */
    println(a + b)

    println(OperatorsAreMethods.+)
    println(OperatorsAreMethods.++)

    /* Both calls to same method */
    println(OperatorsAreMethods.+(1))
    println(OperatorsAreMethods + 1)

    /* Both calls to same method */
    println(OperatorsAreMethods.++(1))
    println(OperatorsAreMethods ++ 1)
  }

  def +() {
    println("+")
  }

  def +(param: Int) {
    println(param + "+")
  }

  def ++() {
    println("++")
  }

  def ++(param: Int) {
    println(param + "++")
  }
}