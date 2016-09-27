package com.inbravo.lang

/**
 * Say hello
 */
class Greeter(val name: String) {

  def sayHello = "Hello " + name;
}

/**
 *
 */
object ImplicitFuncTest {

  /* Create new implicit greet method */
  implicit def greet(name: String) = new Greeter(name)

  /* Create new name */
  val name = "InBravo"

  /* Create new Greeter */
  val greeter = new Greeter(name)

  def main(args: Array[String]): Unit = {

    /* Say hello using simple method call */
    println(greeter.sayHello)

    /* Say hello using implicit method call */
    println(name.sayHello)
  }
}
