package com.inbravo.lang

object LoopTest extends App {

  var i = 0
  var max = 100

  /* while loop */
  while (i < max) {

    printIt(i)
    i += 1
  }

  /* for loop */
  for (i <- 0 until max) {

    printIt(i)
  }

  /* For each */
  (0 until max).foreach(printIt)

  /* Print from 1 to 10 */
  for (i <- 1 to 10) yield printIt(i)

  /* Array of 5 values */
  val a = Array(1, 2, 3, 4, 5)

  /* printIt */
  for (e <- a) yield printIt(e)

  /* printIt only for values greater than 2 */
  for (e <- a if e > 2) yield printIt(e)

  def printIt(value: Int) = println(value)
}