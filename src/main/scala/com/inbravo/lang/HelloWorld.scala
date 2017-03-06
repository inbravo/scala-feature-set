package com.inbravo.lang

/**
 * First test program
 *
 * amit.dixit
 */
object HelloWorld {

  /**
   *  Entry point of program : main method
   *  Parameter passed : 'scala.Array' of 'Predef.String'
   *  'Predef.String' eventually calls 'java.lang.String'
   */
  def main(args: Array[String]): Unit = {

    /* Control flow : scala.Predef.println --> scala.Console.println --> java.io.PrintStream.println */
    println("Hello World")
  }
}