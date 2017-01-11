package com.inbravo.lang

/**
 *
 * A function without a return type
 */
object ProcedureTest {

  def main(args: Array[String]): Unit = {

    hello; box("I am a poor human")
  }

  /* A function without a Return Type is called Procedure. Look carefully: there is no '=' */
  def box(s: String) {

    val border = "-" * s.length + "--\n"
    println(border + "|" + s + "|\n" + border)
  }

  /* A function without a Return Type is called Procedure. Just print a 'Hello' */
  def hello = print("Hello")
}