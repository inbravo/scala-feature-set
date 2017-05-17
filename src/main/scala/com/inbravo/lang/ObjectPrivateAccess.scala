package com.inbravo.lang
/**
 * This example showcases the difference between private and private[this]
 * amit.dixit
 */
object ObjectPrivateAccess extends App {

  class Employee {

    /* Accessing someObject.value is not allowed */
    private[this] var privateValue = 0

    /* Accessing someObject.value is allowed */
    var publicValue = 0
  }

  /* Difference between private and private[this] */
  class EmployeeManager(employeeManager: EmployeeManager) {

    /* Only accesible to 'this' */
    private[this] val privateEmployeeManagerValue = 2

    println(this.privateEmployeeManagerValue)

    /* This line will give compilation error */
    //  println(employeeManager.privateEmployeeManagerValue) 
  }

  /* Create new employee */
  var employee = new Employee

  println("privateValue: " + employee.publicValue)

  /* Field 'privateValue' wont be accesible = employee.privateValue */
}

