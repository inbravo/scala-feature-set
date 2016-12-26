package com.inbravo.number

import scala.annotation.tailrec

/**
 * How @tailrec works
 *
 * amit.dixit
 */
object FactorialTest {

  val factorial = new FactorialTest

  def main(args: Array[String]): Unit = {

    try {

      println(factorial.enhancedFactorial(500))
    } catch {
      case e: Exception => e.printStackTrace
    }
  }
}

class FactorialTest {

  final def factorial(number: BigInt): BigInt = if (number == 0) { 1 } else { number * factorial(number - 1) }

  final def enhancedFactorial(number: BigInt): BigInt = {

    /* Use an accumulator so that multiplication happens before the recursive call */
    @tailrec def factorialAcc(accumulator: BigInt, number: BigInt): BigInt = {

      /* If number is less than 1 */
      if (number <= 1) {

        accumulator
      } else {

        /* For all other numbers */
        factorialAcc(number * accumulator, number - 1)
      }
    }

    /* Call an internal method */
    return factorialAcc(1, number)
  }
}