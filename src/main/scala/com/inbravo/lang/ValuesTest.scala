package com.inbravo.lang

/**
 * Following program helps in undersanding the various Scala types
 *
 * amit.dixit
 */
object ValuesTest extends App {

  /* Different Scala types, initialized with their maximum value */
  val maxByteValue: Byte = Byte.MaxValue
  val maxCharValue: Char = Char.MinValue
  val maxShortValue: Short = Short.MaxValue
  val maxIntValue: Int = Int.MaxValue
  val maxLongValue: Long = Long.MaxValue
  val maxLloatValue: Float = Float.MaxValue
  val maxDoubleValue: Double = Double.MaxValue

  /* Print values. For Char minimum value, which is '\uFFFF', which is not a printable character by definition, so a trick is used */
  println("Byte Max Value: " + maxByteValue + ", Char Max Value: " + (maxCharValue + 0) + ", Short Max Value: " + maxShortValue)
  println("Int Max Value: " + maxIntValue + ", Long Max Value: " + maxLongValue)
  print("Float Max Value: " + maxLloatValue + ", Double Value: " + maxDoubleValue)
}