package com.inbravo.lang

/**
 * Hello World program without main method, unlike Java, using scala.App class
 * Extend scala.App to avoid usage of main method
 *
 * amit.dixit
 */
object HelloWorldWithoutMain extends App {

  /* Control flow : scala.Predef.println --> scala.Console.println --> java.io.PrintStream.println */
  println("Hello World")
}