package com.inbravo.lang

/**
 * amit.dixit
 *
 * https://mbonaci.github.io/scala
 */
object VarArgsTest extends App {

  /* This method may be called with zero or more parameters */
  def echo(args: String*) = for (arg <- args) println(arg)

  /* To pass in an `Array[String]` instead, you need to  append the argument with a colon and an `_*` symbol */
  echo(Array("arr", "of", "strings"): _*)
}