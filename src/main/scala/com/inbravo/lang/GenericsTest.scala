package com.inbravo.lang

/**
 *
 */
class GenericsTest[Edible, Drinkable] {

  def main(args: Array[String]): Unit = {}

  trait Edible {
    def containsSweet: Boolean
    def containsSalt: Boolean
  }

  trait Drinkable {
    def containsCaffiene: Boolean

    /* 'Unit' is the same as 'void' */
    def containsAlcohal: Unit
  }
}