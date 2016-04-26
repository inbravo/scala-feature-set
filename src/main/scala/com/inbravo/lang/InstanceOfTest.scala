package com.inbravo.lang
/**
 *
 */
object InstanceOfTest extends App {

  /* Create new stack */
  var stack = new com.inbravo.ds.stack.Stack()

  /* Check if instance belongs to Stack class */
  println(stack.isInstanceOf[com.inbravo.ds.stack.Stack])
}