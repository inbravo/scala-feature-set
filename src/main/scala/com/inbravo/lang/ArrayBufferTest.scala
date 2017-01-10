package com.inbravo.lang

/**
 * Java has ArrayList and C++ has vector for arrays that grow and shrink on demand. The equivalent in Scala is ArrayBuffer
 */
object ArrayBufferTest {

  def main(args: Array[String]): Unit = {

    import scala.collection.mutable.ArrayBuffer

    /* An empty array buffer, ready to hold integers */
    /* Or new ArrayBuffer[Int] */
    val b = ArrayBuffer[Int]()

    /* Add an element at the end with += */
    b += 1

    /* Add multiple elements at the end by enclosing them in parentheses */
    b += (1, 2, 3, 5)

    /* You can append any collection with the ++= operator */
    b ++= Array(8, 13, 21)

    /* Removes the last five elements */
    b.trimEnd(5)

    println(b)
  }
}