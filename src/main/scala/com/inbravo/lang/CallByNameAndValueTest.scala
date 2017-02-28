package com.inbravo.lang

/**
 * Writing a method and passing in a parameter
 *
 * amit.dixit
 */
class CallByNameAndValueTest {

  /* Random method */
  def time: Long = {
    println("Entered time() ...")
    System.nanoTime
  }

  /* Call by value : evaluates the function arguments before calling the function */
  def callByValue(t: Long): Long = {
    println("Entered callByValue, calling t ...")
    println("t = " + t)
    println("Calling t again ...")
    t
  }

  /*  Call by name : evaluates the function first, and then evaluates the arguments if need be */
  def callByName(t: => Long) = {
    println("Entered callByName, calling t ...")
    println("t = " + t)
    println("Calling t again ...")
    t
  }
}

object CallByNameTestCompanionObject extends App {

  val CallByNameAndValueObject: CallByNameAndValueTest = new CallByNameAndValueTest

  println("---------------------------")
  CallByNameAndValueObject.callByValue(CallByNameAndValueObject.time)

  println("---------------------------")
  CallByNameAndValueObject.callByName(CallByNameAndValueObject.time)
}