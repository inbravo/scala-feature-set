package com.inbravo.lang

/**
 * amit.dixit
 */
object TypeAliasTest extends App {

  /* Tow different types */
  type User = String
  type Age = Int

  /* Call goes to Predef.immutable.Map[A, B]. which creates a map[String => Int] */
  var data: Map[User, Age] = Map.empty

  /* Add some data in map using plus(+) operator */
  data = data + ("Amit" -> 36)
  data = data + ("Anuj" -> 31)

  /* Add some data in map using plus and equals(+=) operator and retain new map in map in old one */
  data += ("Aniket" -> 12)
  data += ("Arihant" -> 6)

  println(data)

  /* Abstract Type Member of rigid type 'Int' */
  type intOnlyType <: Int

  /* Below given line wont compile */
  /* var intVar:intOnlyType = "" */
}