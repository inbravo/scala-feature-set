package com.inbravo.lang

/**
 * amit.dixit
 * Behaves like singleton object but keep a class with same name
 */
object CompanionObjectTest {

  def main(args: Array[String]): Unit = {

    /* Create new valid employee */
    var emp = new Employee(123, "InBravo", "Noida")

    /* Create new invalid employee: will throw 'java.lang.IllegalArgumentException' */
    var invalidEmp = new Employee(0, "InBravo", "Noida")

    /* Call toString on class */
    println(emp)

    /* Call save on object */
    Employee.save(emp)

    /* Call save on object */
    Employee.update(emp)
  }
}

/*
 * Companion class
 */
class Employee(id: Int, n: String, p: String) {

  /* Require method will ensure that employee id is always valid */
  require(id > 0, "Invalid Employee Id")

  val empId = id
  val name = n
  val place = p

  override def toString() = this.empId + " " + this.name + ", " + this.place
}

/*
 * Companion object
 */
object Employee {

  def save(emp: Employee) = println("Saving: " + emp.name + " ......")

  /* Will throw 'scala.NotImplementedError' */
  def update(emp: Employee) = ???
}