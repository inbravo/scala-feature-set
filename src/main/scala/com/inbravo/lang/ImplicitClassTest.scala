package com.inbravo.lang
/**
 * An example to understand implicit class works
 * amit.dixit
 */
object ImplicitClassTest {

  def main(args: Array[String]): Unit = {

    /* Create new variable 'name' */
    val name = "InBravo"

    /* See carefully that 'sayHello' does not belong to original Predef.String */
    println(name.sayHello)
  }

  /* Implicit class with a method 'sayHello'. A constructor parameter is must for any implicit class */
  implicit class Greeter(val name: String) {

    /* All the methods of any implicit class are bound to context */
    def sayHello = "Hello " + name;
  }
}