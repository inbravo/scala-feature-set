package com.inbravo.lang
/**
 *
 * How to define variables: 'var'
 * How to define constant values: 'val'
 * How definitions or functions can be created using 'var' and 'val'
 *
 * amit.dixit
 */
object VarAndValTest extends App {

  /* Without type */
  var variable = 0

  /* With type ascription (NAME:ASCRIPTION) */
  var variableWithType: Int = 10

  /* Without type ascription */
  val value = 8 * 5 + 2

  /* With type */
  val valueWithType: Int = 10 * 5 + 2

  /* A variable, value and definition, doing same jobs (increment of integer value) */
  var incrementVar = (x: Int) => x + 1 /* A definition using 'var' */
  val incrementVal = (x: Int) => x + 1 /* A definition using 'val' */
  def incrementDef = (x: Int) => x + 1 /* A definition using 'def' */

  /* Everyone will print '2' */
  println(incrementVar(1))
  println(incrementVal(1))
  println(incrementDef(1))
}
