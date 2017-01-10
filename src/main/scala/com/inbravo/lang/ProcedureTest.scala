package com.inbravo.lang

/**
 *
 * A function without a return type
 */
object ProcedureTest {

  def main(args: Array[String]): Unit = {

    box("I am a poor human")
  }

  /* A function without a Return Type is called Procedure */
  def box(s: String) {

    /* Look carefully: no '=' */
    val border = "-" * s.length + "--\n"
    println(border + "|" + s + "|\n" + border)
  }
}