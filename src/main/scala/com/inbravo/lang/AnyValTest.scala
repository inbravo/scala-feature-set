package com.inbravo.lang

import scala.collection.mutable.ArrayBuffer
/**
 *
 * 'Any' is the root of Scala types
 *
 * amit.dixit
 */
object AnyValTest extends App {

  /* A dummy class */
  class Person

  /* A buffer which can store 'Any' */
  val allThings = ArrayBuffer[Any]()

  /* Int, kept as low-level 'int' during runtime */
  val myInt = 10

  /* Add an Int (extends AnyVal). boxed (!) -> becomes java.lang.Integer in the collection */
  allThings += myInt

  /* Person (extends AnyRef), no magic here */
  allThings += new Person
}