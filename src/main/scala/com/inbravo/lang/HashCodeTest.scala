package com.inbravo.lang
/**
 *
 * Different ways to find hash code of a object in Scala
 */
object HashCodeTest extends App {

  /* A valid EmptyTrait */
  val emptyTrait = new EmptyTrait {}

  /*  Will print something like 'com.inbravo.lang.HashCodeTest$$anon$2@1540e19d' */
  println(emptyTrait)

  /* Hashcode of 'emptyTrait'. All three methods will print same 10 digit HashCode value */
  println(emptyTrait ##)
  println(emptyTrait hashCode)
  println(System identityHashCode (emptyTrait))
}