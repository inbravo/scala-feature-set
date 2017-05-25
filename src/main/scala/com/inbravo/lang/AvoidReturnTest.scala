package com.inbravo.lang

/**
 * Why not to use 'return' statement in a Scala program
 *
 * amit.dixit
 */
object AvoidReturnTest {

  /* Scala code below resembles Java */
  def getErrorMessageWithReturnFirst(errorCode: Int): String = {

    /* A variable ('var') type which can change after declaration */
    var result: String = "Unknown Error"

    errorCode match {
      case 1 => result = "TCP Socket Failure"
      case 2 => result = "UDP Failure"
      case 3 => result = "Unknown Error"
    }

    /* Return the result */
    return result
  }

  /* Scala code below resembles Java */
  def getErrorMessageWithExplicitReturnSecond(errorCode: Int): String = {

    /* A value ('val') type which can't change after declaration */
    val result = errorCode match {
      case 1 => "TCP Socket Failure"
      case 2 => "UDP Failure"
      case 3 => "Unknown Error"
    }

    /* Return the result */
    return result
  }

  /* Scala code below somewhat resembles Java */
  def getErrorMessageWithExplicitReturnThird(errorCode: Int): String = {

    /* Control structure 'match' is returning a String */
    return errorCode match { case 1 => "TCP Socket Failure" case 2 => "UDP Failure" case 3 => "Unknown Error" }
  }

  /* Scala code below rarely resembles Java */
  def getErrorMessageWithoutReturn(errorCode: Int): String = {

    /* Control structure 'match' is the last statement in this method; automatically taken as return value */
    errorCode match { case 1 => "TCP Socket Failure" case 2 => "UDP Failure" case 3 => "Unknown Error" }
  }

  def main(arms: Array[String]): Unit = {

    /* First method */
    println(getErrorMessageWithReturnFirst(1))

    /* Second method */
    println(getErrorMessageWithExplicitReturnSecond(1))

    /* Third method */
    println(getErrorMessageWithExplicitReturnThird(1))

    /* Fourth method */
    println(getErrorMessageWithoutReturn(1))
  }
}