package com.inbravo.lang

import scala.collection.mutable.HashMap
/**
 *
 */
object MapTest {

  /* Methods are introduced with def */
  /* Return type comes after the method */
  /* "=" marks the implementation */
  /* Unit is like void */
  def main(args: Array[String]): Unit = {

    val map = HashMap(1 -> "b", 2 -> "a", 3 -> "c")

    /* Get value on key '1' */
    println(map(1))

    /* Add another key-value in map */
    map + (4 -> "d")

    /* println is defined in scala.Predef, which automatically gets imported */
    println(map)
  }
}