package com.inbravo.lang

object LoopTest extends App {

  var i = 0
  var max = 100

  /* while loop */
  while (i < max) {

    doStuff(i)
    i += 1
  }

  /* for loop */
  for (i <- 0 until max) {

    doStuff(i)
  }

  /* For each */
  (0 until max).foreach(doStuff)

  def doStuff(value: Int) {

    println(value)
  }
}