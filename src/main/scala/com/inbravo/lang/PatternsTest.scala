package com.inbravo.lang

object PatternsTest extends App {

  "foo" match {
    case 'f' :+: "ooo"        => println("Not me.")
    case 'f' :+: 'o' :+: rest => println("The rest is " + rest + ".")
  }
}

// Taking advantage of operator sugar enhances readability:
object :+: {

  def apply(c: Char, s: String) = c + s

  def unapply(s: String): Option[(Char, String)] = s match {
    case "" => None
    case _  => Some((s.charAt(0), s.substring(1)))
  }
}