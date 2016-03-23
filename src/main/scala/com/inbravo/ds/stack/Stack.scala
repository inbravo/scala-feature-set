package com.inbravo.ds.stack

import java.util.concurrent.atomic.AtomicInteger
import scala.collection.mutable.ArrayBuffer

/**
 *
 */
final class Stack {

  /* Array for local storage */
  private var storage = Array[Long](0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

  /* Current index stack */
  private var currentIndex = new AtomicInteger(-1)

  /**
   * Put value at index + 1
   *
   * @param value
   */
  def push(value: Long) = this.storage(this.currentIndex.incrementAndGet()) = value

  /**
   * Method or API
   *
   * @param value
   */
  def pop(): Long = {

    /* Return value at current index */
    var poppedValue = this.storage(this.currentIndex.get())

    /* Reset the current index */
    this.storage(this.currentIndex.getAndDecrement()) = 0

    return poppedValue
  }

  /**
   * Return value at current index
   *
   * @param value
   */
  private def peek(): Long = return this.storage(currentIndex.get())

  /**
   * Check if index = max size
   *
   * @param value
   */
  def isFull(): Boolean = return (this.currentIndex.get() == (this.storage.length - 1))

  /**
   * Check if index = -1
   *
   * @param value
   */
  def isEmpty(): Boolean = return (currentIndex.get() == -1)

  override def toString(): String = return (java.util.Arrays.toString(this.storage))
}