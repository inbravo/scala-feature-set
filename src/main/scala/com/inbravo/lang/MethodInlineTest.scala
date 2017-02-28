package com.inbravo.lang

/**
 * amit.dixit
 * Optmization using @inline
 */
object MethodInlineTest extends App {

  final class ClassOne {

    @inline final def t1 = 2
    @inline final def t2 = 3
  }

  final class ClassTwo {

    def t1 = 2
    def t2 = 3
  }

  var objectOne = new ClassOne
  println(objectOne.t1)
  println(objectOne.t2)

  var objectTwo = new ClassTwo
  println(objectTwo.t1)
  println(objectTwo.t2)
}
