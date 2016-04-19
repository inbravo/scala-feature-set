package com.inbravo.ds.queue

import java.util.concurrent.atomic.AtomicInteger

/**
 * FORM: Front at 0 and Rear at Minus 1 (-1)
 */
final class CircularQueue {

  /* Array for local storage */
  private var storage = Array[Long](0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

  /* Maximum size limit of queue */
  private var maxSize = 10

  /* Numbers of item in queue */
  private var currentItemsCount = new AtomicInteger(0)

  /* Front of queue */
  private var front = new AtomicInteger(0);

  /* Rear of queue */
  private var rear = new AtomicInteger(-1);

  /* Push elements at rear of queue */
  def insert(value: Long) = {

    /* Check if full */
    if (!isFull()) {

      /* If Rear = Max Size; Make the queue circular */
      if (this.rear.get() == (this.maxSize - 1)) {

        /* Reset the rear */
        this.rear.set(-1);
      }

      this.storage(this.rear.incrementAndGet()) = value

      /* Increment the current items count */
      currentItemsCount.incrementAndGet();
    } else {

      /* Throw error */
      throw new RuntimeException("Queue is full");
    }
  }

  /* Remove elements from front of queue */
  def remove(): Long = {

    /* Check if empty */
    if (!isEmpty()) {

      /* If Front = Max Size; Make the queue circular */
      if (this.front.get() == this.maxSize) {

        /* Reset the rear */
        this.rear.set(-1);
      }

      /* Take value from front */
      var removedValue = this.storage(this.front.get())

      /* Decrement the current items count */
      currentItemsCount.getAndDecrement();

      /* Reset the current front value and increment */
      this.storage(this.front.getAndIncrement()) = 0

      return removedValue;

    } else {

      /* Throw error */
      throw new RuntimeException("Queue is empty");
    }
  }

  /* See what is at front of queue */
  def peekFront(): Long = return this.storage(front.get())

  /* Check if queue is full */
  def isFull(): Boolean = return (currentItemsCount.get() == maxSize)

  /* Check if queue is empty */
  def isEmpty(): Boolean = return (currentItemsCount.get() == 0)

  /* Print current state of queue */
  override def toString(): String = return (java.util.Arrays.toString(this.storage))
}