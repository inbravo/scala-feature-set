package com.inbravo.lang

/**
 * 	amit.dixit
 */
object MatchCaseTest extends App {

  val firstArg = if (args.length > 0) args(0) else ""

  firstArg match {

    case "salt"  => println("pepper")
    case "chips" => println("salsa")
    case "eggs"  => println("bacon")

    /* '_' is placeholder for a unknown value */
    case _       => println("huh?")
  }

  /* Match can work for */
  ("a ", 3, "-tuple") match {
    case (a, b, c) => println("matched " + a + b + c)
    case _         =>
  }

  /* Match can work for */
  ("a ", 2, 2, "-tuple") match {
    case (a, b, c, d) => println("matched " + a + (b + c) + d)
    case _            =>
  }
}