package com.inbravo.lang

/**
 *
 */
object ApplyMethodTest extends App {

  /* Object as function */
  /* Will call 'apply(name: String)' */
  println(CustomerId("Amit"))

  /* Will call 'apply(id: Int)' */
  println(CustomerId(100))

  /* Will call 'apply(id: Long)' */
  println(CustomerId(100L))

  /* Will call 'apply(id: Double)' */
  println(CustomerId(1000.0))
}

/* Various ways to create customer id from customer name */
object CustomerId {

  /* Apply method helps in constructor calls */
  def apply(name: String) = "ID-" + name
  def apply(id: Int) = id
  def apply(id: Long) = id.intValue
  def apply(id: Double) = id.intValue
}