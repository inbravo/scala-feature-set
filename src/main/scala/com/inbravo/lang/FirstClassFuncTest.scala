package com.inbravo.lang

object FirstClassFuncTest {

  /* Anonymous First-class function as a variable */
  var increment = (x: Int) => x + 1

  /* Anonymous First-class function with name */
  def incrementAgain = (x: Int) => x + 1

  /* Anonymous First-class function as a variable */
  var same = (x: Int) => x

  /* Anonymous First-class function as a variable */
  var square = (x: Int) => x * x

  /* Anonymous First-class function as a variable */
  var cube = (x: Int) => x * x * x

  def main(args: Array[String]): Unit = {

    /* Call variable as function */
    println(increment(10))

    /* Call a definition */
    println(incrementAgain(10))

    /* Sum of numbers from 1 to 5 = 15 */
    println(anotherSum(same, 1, 5))

    /* Sum of square of numbers from 1 to 5 = 55 */
    println(anotherSum(square, 1, 5))

    /* Sum of cube of every numbers from 1 to 5 = 225 */
    println(anotherSum(cube, 1, 5))

    /* Sum of cube of every numbers from 1 to 5 = 225 */
    println(sum(cube)(1, 5))
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {

    /* Inner function definition to loop */
    def loop(a: Int, acc: Int): Int = {

      /* If first number > second number */
      if (a > b) {
        acc
      } /* Else perform the recursive loop again */ else {
        loop(a + 1, f(a) + acc)
      }
    }

    /* Now user loop method to perform sum */
    loop(a, 0)
  }

  /* Another definition of sum function */
  def anotherSum(f: Int => Int, a: Int, b: Int): Int = {

    /* Inner function definition to loop */
    def loop(a: Int, acc: Int): Int = {

      /* If first number > second number */
      if (a > b) {
        acc
      } /* Else perform the recursive loop again */ else {
        loop(a + 1, f(a) + acc)
      }
    }

    /* Now user loop method to perform sum */
    loop(a, 0)
  }
}