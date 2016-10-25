package com.inbravo.lang
/**
 * amit.dixit
 *
 * How anonymous function and type works
 */
object AnonymousFuncTest {

  /* A type which takes some parameters and returns Boolean */
  type SumOfThreeInts = (Int, Int, Int)

  /* Anonymous square function */
  val squareOfIntFunc = new Function1[Int, Int] { def apply(x: Int): Int = x * x }

  /* Anonymous sum function */
  val sumOfTwoIntsFunc = new Function2[Int, Int, Int] { def apply(x: Int, y: Int): Int = x + y }

  /* Anonymous sum function */
  val sumOfThreeIntsFunc = new Function3[Int, Int, Int, Int] { def apply(x: Int, y: Int, z: Int): Int = x + y + z }

  def sum(sumOfThreeInts: SumOfThreeInts): Int = {

    sumOfThreeInts._1 + sumOfThreeInts._2 + sumOfThreeInts._3
  }

  def main(args: Array[String]): Unit = {

    /* Call anonymous functions */
    println("Square 10 :	" + squareOfIntFunc(10))
    println("Sum of two 10 :	" + sumOfTwoIntsFunc(10, 10))
    println("Sum of three 10 :	" + sumOfThreeIntsFunc(10, 10, 10))
    println("Sum of three 10 :	" + sum((10, 10, 10)))

    val threeInts: SumOfThreeInts = (10, 10, 10)

    println("Sum of three 10 :	" + sum(threeInts))
  }
}