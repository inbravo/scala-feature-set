package com.inbravo.lang
/**
 *
 * How to define variables: 'var'
 * How to define constant values: 'val'
 * How definitions or functions can be created using 'var'
 *
 * amit.dixit
 */
object VarAndValTest extends App {

  /* Without type */
  var variable = 0

  /* With type */
  var variableWithType: Int = 10

  /* Without type */
  val value = 8 * 5 + 2

  /* With type */
  val valueWithType: Int = 10 * 5 + 2

  /* A variable, value and definition, doing same jobs (increment of integer value) */
  var incrementVar = (x: Int) => x + 1 /* A definition using 'var' */
  val incrementVal = (x: Int) => x + 1 /* A definition using 'val' */
  def incrementDef = (x: Int) => x + 1 /* A definition using 'def' */
}
