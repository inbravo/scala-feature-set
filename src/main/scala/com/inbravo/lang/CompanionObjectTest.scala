package com.inbravo.lang

/**
 * amit.dixit
 * Behaves like singleton object but keep a class with same name
 */
object CompanionObjectTest {

  def main(args: Array[String]): Unit = {

    /* Create new employee */
    var emp = new Employee(123, "InBravo", "Noida")

    /* Call toString on class */
    println(emp)

    /* Call save on object */
    Employee.save(emp)
  }
}

/*
 * Companion class
 */
class Employee(id: Int, n: String, p: String) {

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
}