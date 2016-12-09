package com.inbravo.lang

/**
 * How lazy value works
 * 
 * amit.dixit
 */
object LazyValTest {

  def main(args: Array[String]) {

    /* A simple value. It will print 'x' */
    val x = { println("x"); 15 }

    /* A lazy value. It will not print anything because nothing is initialized */
    lazy val y = { println("y"); 13 }

    /* A lazy value. It will first initialize 'y' by printing 'y' and then print '13' */
    println(y)
  }
}