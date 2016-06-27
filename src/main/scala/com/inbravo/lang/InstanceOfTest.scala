package com.inbravo.lang
/**
 * amit.dixit
 */
object InstanceOfTest extends App {

  /* Create new stack */
  var stack = new com.inbravo.ds.stack.Stack(10)

  /* Check if instance belongs to Stack class */
  println(stack.isInstanceOf[com.inbravo.ds.stack.Stack])
}