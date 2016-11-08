package com.inbravo.lang
/**
 * amit.dixit
 * How 'foreach' and 'for' loop works
 * How 'yield' is used in loops
 */
object ForEachTest extends App {

  /* Create an array of names */
  val nameList = Array("amit", "sumit", "tanuj", "manuj")

  /* Create array with upper case names using 'yield' */
  val reverseNameList = for (n <- nameList) yield n.toUpperCase()

  /* Print the elements of list */
  for (n <- reverseNameList) println(n)

  /* Example of 'foreach' */
  nameList.foreach(n => println("Hi, " + n))
}