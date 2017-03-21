package com.inbravo.lang

/**
 * First test program
 *
 * amit.dixit
 */
object HelloWorld {

  /**
   *  Entry point of program : equivalent of Java main method
   *  Parameter passed : 'scala.Array' of 'Predef.String'
   *  Property 'scala.Predef.String' eventually calls 'java.lang.String'
   *  Scala object 'scala.Predef' is a placeholder for mostly used Scala classes
   */
  def main(args: Array[String]): Unit = {

    /* Control flow : scala.Predef.println --> scala.Console.println --> java.io.PrintStream.println */
    println("Hello World")
  }
}