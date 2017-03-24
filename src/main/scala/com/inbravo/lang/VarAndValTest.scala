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

  /* A variable and a definition, doing same job (increment of integer value) */
  /* A definition */
  def incrementFunction = (x: Int) => x + 1

  /* A variable as a definition */
  var incrementVariable = (x: Int) => x + 1
}