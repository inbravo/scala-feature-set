package com.inbravo.ds.stack

import java.util.concurrent.atomic.AtomicInteger

/**
 *
 */
object StackTest extends App {

  /* Create new stack */
  var stack = new com.inbravo.ds.stack.Stack()

  /* Check for full */
  println("Stack is full ? " + stack.isFull())

  /* Check for empty */
  println("Stack is empty ? " + stack.isEmpty())

  println("Before element push : " + stack.toString())

  for (i <- 0 to 9) {

    /* Push items on stack */
    stack.push(i + 10)
  }

  println("After element push : " + stack.toString())

  while (!stack.isEmpty()) {
    println("Popped " + stack.pop())
  }

  println("After element pop : " + stack.toString())
}