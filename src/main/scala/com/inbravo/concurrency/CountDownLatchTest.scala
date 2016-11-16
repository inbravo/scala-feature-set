package com.inbravo.concurrency

import java.util.concurrent.CountDownLatch

/**
 * amit.dixit
 */
object CountDownLatchTest {

  def main(args: Array[String]): Unit = latchTest()

  def latchTest() {

    val doneSignal = new CountDownLatch(2)

    /* Count down 2 times */
    doneSignal.countDown()
    doneSignal.countDown()

    /* Wait here until all count down completed */
    doneSignal.await()

    println("both workers finished!")
  }
}