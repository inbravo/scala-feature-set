package com.inbravo.lang

/**
 * amit.dixit
 * Behaves like singleton object but keep a class with same name
 */
object CompanionObjectTest {

  val SpiderLegs = 8
  def humanLegs = 2

  def main(args: Array[String]): Unit = {

    println(CompanionObjectTest.SpiderLegs)
  }
}

/*	Class with same name */
/*  There is no such thing as static in Scala */
/*	You can define a top-level object with the same name as your class; this is called a “companion object”, and so you can get the same static access syntax as Java */
/*	There are only two namespaces, values and types. The object is a value, the class is a type; that’s why they can have the same name */
/*	The object can extend classes and apply mixins, so you can abstract and reuse the functionality much better */

class CompanionObjectTest