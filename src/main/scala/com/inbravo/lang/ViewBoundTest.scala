package com.inbravo.lang

/**
 * This object helps in understanding of view type bounds
 *
 * amit.dixit
 */
object ViewBoundTest extends App {

  val p1 = new Person("A", "D")
  val p2 = new Person("E", "A")
  val p3 = new Person("G", "A")

  println(p1.greater)
  println(p2.greater)
  println(p3.greater)
}

/* Scala’s View Bound operator '<%' means that 'T' should have an implicit conversion to' Ordered[T]' available */
class Person[T <% Ordered[T]](val firstName: T, val lastName: T) {

  def greater = if (firstName > lastName) firstName else lastName
}
 