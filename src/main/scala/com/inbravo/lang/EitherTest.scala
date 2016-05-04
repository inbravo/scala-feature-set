package com.inbravo.lang
/**
 * amit.dixit
 */
object EitherTest extends App {

  /**
   * A simple method to demonstrate how to declare that a method returns an Either
   */
  def divide(x: Int, y: Int): Either[String, Int] = {

    if (y == 0) { Left("Dude, can't divide by 0") }
    else { Right(x / y) }
  }

  /* Many ways to use Either, Left, and Right */
  println(divide(1, 0))
  println(divide(1, 1))

  divide(1, 0) match {
    case Left(s)  => println("Answer: " + s)
    case Right(i) => println("Answer: " + i)
  }
}