package com.inbravo.concurrency

import java.util.concurrent.{ CyclicBarrier, BrokenBarrierException }

/**
 * Test Java concurrency class CyclicBarrier
 * amit.dixit
 */
object CyclicBarrierTest {

  def main(args: Array[String]): Unit = cyclicBarrierTest()

  def cyclicBarrierTest() {

    /* Create new CyclicBarriers which can withhold 2 threads at max */
    var CyclicBarrierOne: CyclicBarrier = new CyclicBarrier(2, new Runnable {

      override def run {
        System.out.println("barrierOneAction executed ")
      }
    })

    /* Second barrier action */
    var CyclicBarrierTwo: CyclicBarrier = new CyclicBarrier(2, new Runnable {

      override def run {
        System.out.println("barrierTwoAction executed ")
      }
    })

    /* Create new runnable behavior */
    var runnable = new CyclicBarrierDoubleRunnable(CyclicBarrierOne, CyclicBarrierTwo)

    /* Create two anonymous threads on CyclicBarrierRunnable */
    new Thread(runnable).start()
    new Thread(runnable).start()

    /*
     * Third thread will never pass from CyclicBarrier because of number of allowed parties is 2
     * only
     */
    // new Thread(runnable).start()
  }
}

final class CyclicBarrierDoubleRunnable(cyclicBarrierOne: CyclicBarrier, cyclicBarrierTwo: CyclicBarrier) extends Runnable {

  override def run() {

    try {
      Thread.sleep(1000);

      System.out.println(Thread.currentThread().getName() + " waiting at barrier One");
      this.cyclicBarrierOne.await();

      Thread.sleep(1000);
      System.out.println(Thread.currentThread().getName() + " waiting at barrier Two");
      this.cyclicBarrierTwo.await();

      System.out.println(Thread.currentThread().getName() + " done!");

    } catch {

      /* Check for all exception cases */
      case e: InterruptedException   => e.printStackTrace()
      case e: BrokenBarrierException => e.printStackTrace()
    }
  }
}