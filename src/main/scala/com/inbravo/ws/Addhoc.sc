package com.inbravo.ws

object Addhoc {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  /* Example for polymorphism in method parameters */
  def testGenericMethod(any: AnyVal) = { if (Int.MinValue == any) println("--" + any) }
                                                  //> testGenericMethod: (any: AnyVal)Unit

  testGenericMethod(Long.MinValue)
  testGenericMethod(Int.MinValue)                 //> ---2147483648

  /* Example for 'lazy val' */
  val x = { println("x"); 15 }                    //> x
                                                  //| x  : Int = 15
  lazy val y = { println("y"); 13 }               //> y: => Int

  println(y)                                      //> y
                                                  //| 13
  new X                                           //> res0: com.inbravo.ws.X = com.inbravo.ws.X@6e1ec318
  new Y                                           //> res1: com.inbravo.ws.Y = com.inbravo.ws.Y@7e0b0338

  val numbers = Array(1, 2, 3, 4, 5)              //> numbers  : Array[Int] = Array(1, 2, 3, 4, 5)
  val sum = numbers.reduce[Int](_ * _)            //> sum  : Int = 120

  println("The sum of the numbers one through five is " + sum)
                                                  //> The sum of the numbers one through five is 120
}

/* Example for 'lazy val' */
class X { val x = { Thread.sleep(2000); 15 } }
class Y { lazy val y = { Thread.sleep(2000); 13 } }