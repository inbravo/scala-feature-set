package com.inbravo.lang

/**
 * amit.dixit
 *
 * https://mbonaci.github.io/scala
 */
object VarArgsTest extends App {

  /* This method may be called with zero or more parameters */
  def echo(args: String*) = for (arg <- args) println(arg)

  /* This method may be called with zero or more parameters */
  def echoInt(args: Int*) = for (arg <- args) println(arg)

  /* This method may be called with zero or more parameters */
  def echoDouble(args: Double*) = for (arg <- args) println(arg)

  /* To pass in an array, need to  append the argument with a colon and an `_*` symbol */
  /* Append ': _*' to tell the compiler that you want the parameter to be considered an argument sequence */
  echo(Array("arr", "of", "strings"): _*)
  echoInt(Array(1, 2, 3, 4, 5, 6, 7, 8, 9): _*)
  echoDouble(Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0): _*)
}