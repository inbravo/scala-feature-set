package com.inbravo.lang

/**
 * Sealed Trait is like Java ENUM
 *
 *  Case classes/object differ from regular classes/object in that they get:
 *
 * ~ pattern matching support
 * ~ default implementations of equals and hashCode
 * ~ default implementations of serialization
 * ~ a prettier default implementation of toString, and
 * ~ the small amount of functionality that they get from automatically inheriting from scala.Product.
 */
object SealedTraitTest {

  sealed trait Answer
  case object Yes extends Answer
  case object No extends Answer

  object Suit extends Enumeration {
    val Spades, Hearts, Clubs, Diamonds = Value
  }

  /* Main method for execution */
  def main(args: Array[String]): Unit = {

    println(Yes.hashCode())
    println(No.hashCode())
  }
}