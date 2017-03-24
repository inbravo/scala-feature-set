package com.inbravo.lang

/**
 * Following program helps in undersanding the various Scala types
 *
 * amit.dixit
 */
object ValuesTest extends App {

  /* Different Scala types, initialized with their maximum value and with their types (NAME:TYPE e.g. val maxByteValue: Byte) */
  val maxByteValue: Byte = Byte.MaxValue
  val maxCharValue: Char = Char.MaxValue
  val maxShortValue: Short = Short.MaxValue
  val maxIntValue: Int = Int.MaxValue
  val maxLongValue: Long = Long.MaxValue
  val maxFloatValue: Float = Float.MaxValue
  val maxDoubleValue: Double = Double.MaxValue

  /* Print values */
  println("Byte Max Value: " + maxByteValue)

  /* Trick is used to convert a Char to yeild numeric value */
  println("Char Max Value: " + (maxCharValue + 0))
  println("Short Max Value: " + maxShortValue)
  println("Int Max Value: " + maxIntValue)
  println("Long Max Value: " + maxLongValue)
  println("Float Max Value: " + maxFloatValue)

  /* Method print does not ends with a new line */
  print("Double Max Value: " + maxDoubleValue)

  /* Different Scala types, initialized with their minimum value and without their types */
  val minByteValueWithoutType = Byte.MinValue
  val minCharValueWithoutType = Char.MinValue
  val minShortValueWithoutType = Short.MinValue
  val minIntValueWithoutType = Int.MinValue
  val minLongValueWithoutType = Long.MinValue
  val minFloatValueWithoutType = Float.MinValue
  val minDoubleValueWithoutType = Double.MinValue

  /* Print values */
  println("Byte Min Value: " + minByteValueWithoutType)

  /* Trick is used to convert a Char to yeild numeric value */
  println("Char Min Value: " + (minCharValueWithoutType + 0))
  println("Short Min Value: " + minShortValueWithoutType)
  println("Int Min Value: " + minIntValueWithoutType)
  println("Long Min Value: " + minLongValueWithoutType)
  println("Float Min Value: " + minFloatValueWithoutType)

  /* Method print does not ends with a new line */
  print("Double Min Value: " + minDoubleValueWithoutType)
  
  /* Boolean values */
  val trueBoolean: Boolean = true
  val falseBoolean: Boolean = false
}