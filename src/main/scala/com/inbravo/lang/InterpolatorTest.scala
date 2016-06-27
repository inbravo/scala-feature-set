package com.inbravo.lang

/*
 * Usage of 's', 'f' and 'raw'
 */
object InterpolatorTest {

  def main(args: Array[String]): Unit = {

    val name = "amit"

    /* Usage of 's' */
    println(s"Hello, $name")

    println(s"1 + 1 = ${1 + 1}")

    val height = 1.9d

    /* Usage of 'f' */
    println(f"$name%s is $height%2.2f meters tall")

    /* Usage of 'raw' */
    printf(raw"a\nb\r")
  }
}