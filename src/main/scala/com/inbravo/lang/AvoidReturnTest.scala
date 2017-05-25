package com.inbravo.lang

/**
 * Why not to use 'return' statement in a Scala program
 *
 * amit.dixit
 */
object AvoidReturnTest {

  def getErrorMessageWithReturn(errorCode: Int): String = {

    /* Variable initializaed the default value using uderscore '_' */
    var result: String = "Unknown Error"

    errorCode match {
      case 1 => result = "TCP Socket Failure"
      case 2 => result = "UDP Failure"
      case 3 => result = "Unknown Error"
    }
    return result
  }

  def getErrorMessageWithExplicitReturn(errorCode: Int): String = {

    val result = errorCode match {
      case 1 => "TCP Socket Failure"
      case 2 => "UDP Failure"
      case 3 => "Unknown Error"
    }
    return result
  }

  def getErrorMessageWithoutReturn(errorCode: Int): String = {

    /* Control structure 'match' is the last statement in this method and 'match' is returning a String */
    errorCode match {
      case 1 => "TCP Socket Failure"
      case 2 => "UDP Failure"
      case 3 => "Unknown Error"
    }
  }

  def main(arms: Array[String]): Unit = {

    /* First method */
    println(getErrorMessageWithReturn(1))

    /* Second method */
    println(getErrorMessageWithExplicitReturn(1))

    /* THird method */
    println(getErrorMessageWithoutReturn(1))
  }
}