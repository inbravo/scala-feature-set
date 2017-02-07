package com.inbravo.lang

object AuxiliaryConstructorsTest extends App {

  class Employee {

    private var name = ""
    private var age = 0

    /* An auxiliary constructor */
    def this(name: String) {

      /* Each auxiliary constructor must start with a call to a previously defined auxiliary constructor or the primary constructor */
      this()
      this.name = name
    }

    /* Another auxiliary constructor */
    def this(name: String, age: Int) {

      /* Each auxiliary constructor must start with a call to a previously defined auxiliary constructor or the primary constructor */
      this(name)
      this.age = age
    }
  }

  /* Primary constructor */
  val p1 = new Employee

  /* First auxiliary constructor */
  val p2 = new Employee("Fred")

  /* Second auxiliary constructor */
  val p3 = new Employee("Fred", 42)

  class Person(val name: String, val age: Int) {

  }
  
  /* Half a line of Scala is the equivalent of seven lines of Java: */
}