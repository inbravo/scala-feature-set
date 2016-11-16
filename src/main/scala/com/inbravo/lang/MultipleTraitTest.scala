package com.inbravo.lang
/**
 * amit.dixit
 */
object MultipleTraitTest {

  trait Car {
    val brand: String
  }

  trait Shiny {
    val shineRefraction: Int
  }

  /* Class with multiple traits using 'with' keyword */
  final class BMW(b: String, s: Int) extends Car with Shiny {

    val brand = b;
    val shineRefraction = s;

    def print() {
      println("brand: " + brand + ", shineRefraction: " + shineRefraction)
    }
  }

  /* Main method for execution */
  def main(args: Array[String]): Unit = new BMW(b = "BMW Sport", s = 11).print()
}