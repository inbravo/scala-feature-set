package com.inbravo.lang

import java.io.IOException
import java.net.SocketException
/**
 * amit.dixit
 */
object TryCatchTest extends App {

  try {

    /* Do something */
    doStuff("A", "B")

  } catch {

    /* Check for all exception cases */
    case e: IOException     => e.printStackTrace()
    case e: SocketException => e.printStackTrace()

  } finally {
    println("done")
  }

  /* Varags */
  def doStuff(value: String*) = println(value)

  /* Unit == Void */
  def doStuff(): Unit = ()
}