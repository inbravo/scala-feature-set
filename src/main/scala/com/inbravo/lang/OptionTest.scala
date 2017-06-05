package com.inbravo.lang

/**
 * How 'scala.option' class used to avoid nullpointerexception
 * amit.dixit
 */
object OptionTest {

  def main(args: Array[String]) {
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

    println("show(capitals.get( \"Japan\")) : " + show(capitals.get("Japan")))
    println("show(capitals.get( \"India\")) : " + show(capitals.get("India")))
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None    => "?"
  }
}