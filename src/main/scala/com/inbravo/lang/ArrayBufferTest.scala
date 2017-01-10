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

    /* Insert before index 2 */
    b.insert(2, 6)

    /* ArrayBuffer(1, 1, 7, 8, 9, 6, 2) */
    b.insert(2, 7, 8, 9)

    /* Remove a element at a index or at a starting index */
    b.remove(2)
    b.remove(2, 3)

    println(b)

    /* 0 until 10 is actually a method call 0.until(10) */
    for (i <- 0 until b.length) {
      println(i + ": " + b(i))
    }

    /* 0 until 10 is actually a method call 0.until(10) */
    for (i <- 0.until(b.length)) {
      println(i + ": " + b(i))
    }

    /* Implicitly converts a 'ArrayBuffer' to a 'java.util.List' */
    import scala.collection.JavaConversions.bufferAsJavaList

    /* The 'ArrayBuffer' is wrapped into an object of a Java class that implements the 'java.util.List' interface */
    val pb = new ProcessBuilder(ArrayBuffer("ls", "-al", "/home/cay"))
  }
}