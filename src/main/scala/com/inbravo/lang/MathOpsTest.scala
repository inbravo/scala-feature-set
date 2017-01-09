package com.inbravo.lang
/**
 * 
 * 
 * amit.dixit
 */
object MathOpsTest {

  def main(args: Array[String]): Unit = {

    /* Both imports are same. top package can be ignored */
    import scala.math._
    import math._

    println(sqrt(2))
    println(pow(2, 4))
    println(min(3, Pi))

    /* Print some prime number */
    /* Random is a singleton random number generator object, defined in the scala.util package */
    println(BigInt.probablePrime(100, scala.util.Random))

    /* Methods without parameters often don’t use parentheses */
    println("Hello".distinct)

    /* You can think of this as an overloaded form of the () operator. It is implemented as a method with the name 'apply' */
    println("Hello"(4))
    println("Hello".apply(4))

    /* Both methods are same. Constructor calls apply method */
    BigInt("1234567890")
    BigInt.apply("1234567890")
  }
}