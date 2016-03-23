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
  
  def push(value: Long) = this.storage(this.currentIndex.incrementAndGet()) = value
  def pop(): Long = return this.storage(this.currentIndex.getAndDecrement())
  def peek(): Long = return this.storage(currentIndex.get())
  def isFull(): Boolean = return (this.currentIndex.get() == (this.storage.length - 1))
  def isEmpty(): Boolean = return (currentIndex.get() == -1)
  override def toString(): String = return (java.util.Arrays.toString(this.storage))
}