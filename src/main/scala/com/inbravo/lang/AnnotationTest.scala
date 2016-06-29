package com.inbravo.lang

import scala.annotation.StaticAnnotation

/**
 *
 */
class MyAnnotation(val p: String) extends StaticAnnotation {}

@MyAnnotation("AAA")
class MyClass {}

object AnnotationTest {

  val myClass = new MyClass
  def main(args: Array[String]) = println(myClass.hashCode())
}  