package com.inbravo.ds.queue

/**
 *
 */
object QueueTest extends App {

  /* Create new queue */
  var queue = new com.inbravo.ds.queue.Queue()

  /* Check for full */
  println("Queue is full ? " + queue.isFull())

  /* Check for empty */
  println("Queue is empty ? " + queue.isEmpty())

  println("Before element insert : " + queue.toString())

  for (i <- 0 to 9) {

    /* Push items in queue */
    queue.insert(i + 10)
  }

  println("After element insert : " + queue.toString())

  while (!queue.isEmpty()) {
    println("Removed " + queue.remove())
  }

  println("After element removed : " + queue.toString())
}