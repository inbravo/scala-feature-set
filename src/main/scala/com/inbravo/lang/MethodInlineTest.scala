package com.inbravo.lang

/**
 * amit.dixit
 *
 * Optmization using @inline
 *
 * A hint could be provided to the compiler through the inline keyword.
 * By doing so, compiler may replace an inlined function call by the function body itself in order to skip the overhead of a function call
 */
object MethodInlineTest extends App {

  final class ClassOne {

    @inline final def t1: Int = {
      println("t1")
      1
    }
    @inline final def t2: Int = {
      println("t2")
      2
    }
  }

  final class ClassTwo {

    /* Create instance of ClassOne */
    val classOne = new ClassOne

    /* Call inlined functions */
    val t1 = classOne.t1
    val t2 = classOne.t2
  }

  /* Create instance of ClassTwo */
  val objectTwo = new ClassTwo

  /* Call values */
  println(objectTwo.t1)
  println(objectTwo.t2)
}
