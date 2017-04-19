package com.inbravo.lang

/**
 * This example shows how object, class and traits work in Scala
 */
object OBJECTA extends CLASSA {

  def main(args: Array[String]): Unit = {

    /* Call printHello. Point to be noted here is that it sounds like a Java static method call */
    OBJECTA.printHello
  }

  /* Method returns nothing but prints string 'Hello' */
  def printHello: Unit = super.print
}

/* Definition of CLASSA, which is extending CLASSB */
class CLASSA extends CLASSB {

  /* Method returns nothing but calls super class method */
  def print: Unit = super.print("Hello")
}

/* Definition of CLASSB */
class CLASSB extends Printer {

  /* Method returns nothing but prints the statement */
  def print(statement: String): Unit = println(statement)
}

/* A simple trait, which is like Java interface */
trait Printer {

  /* A method contract only without definition */
  def print(statement: String): Unit
}