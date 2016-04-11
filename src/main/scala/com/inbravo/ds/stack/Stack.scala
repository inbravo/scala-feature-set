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

  /* Push elements in stack */
  def push(value: Long) = this.storage(this.currentIndex.incrementAndGet()) = value

  /* Pop elements from stack */
  def pop(): Long = return this.storage(this.currentIndex.getAndDecrement())

  /* See what is at top of stack */
  def peek(): Long = return this.storage(this.currentIndex.get())

  /* Check if stack is full */
  def isFull(): Boolean = return (this.currentIndex.get() == (this.storage.length - 1))

  /* Check if stack is empty */
  def isEmpty(): Boolean = return (this.currentIndex.get() == -1)

  /* Print current state of stack */
  override def toString(): String = return (java.util.Arrays.toString(this.storage))
}