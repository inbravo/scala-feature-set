package com.inbravo.lang

/**
 * Scala does not follow the Java convention of prepending set/get to mutator and accessor methods
 *
 * amit.dixit
 */

object MutatorTest {

  def main(args: Array[String]) {

    val employee = new CompilerGeneratedEmployee

    println(employee.name)
    employee.name_=("amit")
    println(employee.name)
  }

  /**
   * This is the class, written by you
   */
  class Employee {

    /* Private field */
    private var name: String = _
  }

  /**
   * This is the class, after compilation
   */
  class CompilerGeneratedEmployee {

    private[this] var internal: String = _

    /* Accessor or Getter: the name of the method should be the name of the property */
    def name: String = internal

    /* Mutator or Setter:  the name of the method should be the name of the property with "_=" appended */
    def name_=(name: String): Unit = internal = name
  }
}