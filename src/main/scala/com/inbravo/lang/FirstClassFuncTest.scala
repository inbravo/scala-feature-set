package com.inbravo.lang

object FirstClassFuncTest {

  /* Anonymous First-class function as a variable */
  var increment = (x: Int) => x + 1

  /* First-class function as a definition */
  def incrementAgain = (x: Int) => x + 1

  /* First-class function as a variable */
  var same = (x: Int) => x

  /* First-class function as a variable */
  var square = (x: Int) => x * x

  /* First-class function as a variable */
  var cube = (x: Int) => x * x * x

  def main(args: Array[String]): Unit = {

    /* Call variable as function */
    println("increment:	" + increment(10))

    /* Call a definition */
    println("incrementAgain:	" + incrementAgain(10))

    /* Sum of numbers from 1 to 5 = 15 */
    println("thirdSum:	" + thirdSum(same, 1, 5))

    /* Sum of numbers from 1 to 5 = 15 */
    println("secondSum:	" + secondSum(same)(1, 5))

    /* Sum of square of numbers from 1 to 5 = 55 */
    println("thirdSum:	" + thirdSum(square, 1, 5))

    /* Sum of cube of every numbers from 1 to 5 = 225 */
    println("thirdSum:	" + thirdSum(cube, 1, 5))

    /* Sum of cube of every numbers from 1 to 5 = 225 */
    println("sum:	" + sum(cube)(1, 5))
  }

  /*
   * Currying	:	sum(inputFunction)(innerFunctionParams)
   */
  def sum(inputFunction: Int => Int)(a: Int, b: Int): Int = {

    /* Inner function definition to loop */
    /* Two input parameters and one output parameter */
    def loop(a: Int, acc: Int): Int = {

      /* If first number > second number */
      if (a > b) {

        return acc
      } else {

        /* Else perform the recursive loop again */
        return loop(a + 1, inputFunction(a) + acc)
      }
    }

    /* Return loop method */
    return loop(a, 0)
  }

  /*
   * Currying	:	secondSum(inputFunction)	:	outputFunction
   */
  def secondSum(inputFunction: Int => Int): (Int, Int) => Int = {

    /* Inner function definition to loop */
    /* Two input parameters and one output parameter */
    def innerSum(a: Int, b: Int): Int = {

      /* If first number > second number */
      if (a > b) {

        return 0
      } else {

        /* Else perform the recursive loop again */
        return inputFunction(a) + innerSum(a + 1, b)
      }
    }

    /* Return loop method */
    return innerSum
  }

  /* Another definition of sum function */
  def thirdSum(inputFunction: Int => Int, a: Int, b: Int): Int = {

    /* Inner function definition to loop */
    def loop(a: Int, acc: Int): Int = {

      /* If first number > second number */
      if (a > b) {

        return acc
      } else {

        /* Else perform the recursive loop again */
        return loop(a + 1, inputFunction(a) + acc)
      }
    }

    /* Return loop method */
    return loop(a, 0)
  }
}