package com.inbravo.lang

/**
 * A complete example to understand; how to define methods in Scala
 *
 * amit.dixit
 */
object MethodTest extends App {

  /* Anonymous method; this does not require an explicit calls but will be automatically called */
  print("Hello")

  /* A method with a name, without any parameter passed, with curly brackets ('{}'); which prints something */
  def printHelloWithCurlyBrackets = { print("Hello") }

  /* A method with a name, without any parameter passed, without curly brackets ('{}'); which prints something */
  def printHello = print("Hello")

  /* A method with a name but without curly brackets ('{}'); which prints something */
  def printIt(value: Int) = print(value)

  /* A method which returns an Int value */
  def returnInt: Int = return 1

  /* A method which returns an Int value without using 'return' keyword */
  def returnIntWithoutTypeDefinition = 1

  /* A method which returns a Float value */
  def returnFloat: Float = return 1.0F

  /* A method which returns a Float value without using 'return' keyword */
  def returnFloatWithoutTypeDefinition = 1.0F

  /* Run all methods */
  print(printHelloWithCurlyBrackets)
  print(printHello)
  print(returnInt)
  print(returnIntWithoutTypeDefinition)
  print(returnFloat)
  print(returnFloatWithoutTypeDefinition)

  /* Watch parenthesis '()' is only required where a method parameter need to be passed */
  print(printIt(1))
}