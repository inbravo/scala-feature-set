package com.inbravo.lang

/**
 * Scala does not follow the Java convention of prepending set/get to mutator and accessor methods
 *
 * amit.dixit
 */

object MutatorTest {

  def main(args: Array[String]) {

    val employee = new Employee
    val cgEmployee = new CompilerGeneratedEmployee

    /* Calls the method employee.name() */
    println(employee.name)

    /* Calls employee.name = "amit"  */
    employee.name = "amit"
    println(employee.name)
    
    /* Value must be in paranthesis ("amit_changed") That is the key difference in assigning value */
    employee.name_=("amit_changed")
    println(employee.name)

    /* Calls the method cgEmployee.name() */
    println(cgEmployee.name)

    /* Calls cgEmployee.name=("amit")  */
    cgEmployee.name_=("amit")
    println(cgEmployee.name)

    println(employee.timeStamp)
  }

  /**
   * This is the class, written by you
   */
  class Employee {

    /* For a private field, the getter and setter methods will be private, so make sure that its not private to get default getters/setters */
    var name: String = _

    /* Scala makes a private final field and a getter method, but no setter */
    val timeStamp = new java.util.Date
  }

  /**
   * This is the class, after compilation
   */
  class CompilerGeneratedEmployee {

    private[this] var internal: String = _

    /* Accessor or Getter: the name of the method should be the name of the property */
    def name: String = internal

    /* Mutator or Setter: the name of the method should be the name of the property with "_=" appended */
    /* Unit is the return type like void in java */
    def name_=(name: String): Unit = { internal = name }
  }
}