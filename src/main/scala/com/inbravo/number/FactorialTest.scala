package com.inbravo.number

/**
 * amit.dixit
 */
object FactorialTest {

  def factorial(number: BigInt): BigInt = if (number == 0) { 1 } else { number * factorial(number - 1) }

  def main(args: Array[String]): Unit = println(factorial(30))
}