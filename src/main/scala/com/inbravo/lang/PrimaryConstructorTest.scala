package com.inbravo.lang

/**
 * amit.dixit
 */
object PrimaryConstructorTest extends App {

  /* Parameters of the primary constructor turn into fields that are initialized with the construction parameters */
  class Employee(val name: String, val age: Int) {

  }

  /* Equivalent Java class */
  /*
	class Employee { 
			private String name;
      private int age;
      
      public Person(String name, int age) {
      
      	this.name = name;
      	this.age = age;
      }
      
			public String name() { 
				return this.name; 
			}
			
			public int age() { 
				return this.age; 
			}
	} 	
  */

  /* Create new employee */
  var employee = new Employee("Fred", 42)

  println(employee.name)
  println(employee.age)
}