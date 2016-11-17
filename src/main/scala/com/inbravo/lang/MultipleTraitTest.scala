package com.inbravo.lang
/**
 * amit.dixit
 */
object MultipleTraitTest {

  trait Car {
    def getBrand(): String
  }

  trait Shiny {
    def getShineRefraction(): Int
  }

  /* Class with multiple traits using 'with' keyword */
  final class BMW(brand: String, shineRefraction: Int) extends Car with Shiny {

    def getBrand(): String = brand
    def getShineRefraction(): Int = shineRefraction

    def print() {
      println("brand: " + getBrand + ", shineRefraction: " + getShineRefraction)
    }
  }

  /* Main method as execution entry point */
  def main(args: Array[String]): Unit = new BMW(brand = "BMW Sport", shineRefraction = 11).print()
}