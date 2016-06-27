package com.inbravo.concurrency
/**
 *
 */
object ThreadTest {

  def main(args: Array[String]): Unit = createThreads()

  def createThreads() {

    /* Create multiple threads */
    for (i <- 1 to 100) {

      /* Create anonymous thread */
      val thread = new Thread {

        override def run {
          println("Thread: " + i)
        }
      }
      thread.start

      Thread.sleep(50)
    }
  }
}