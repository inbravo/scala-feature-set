package com.inbravo.string

import java.util.concurrent.atomic.AtomicInteger

/**
 * amit.dixit
 * First object
 */
object WordFrequency {

  def main(args: Array[String]): Unit = {

    /* This is the original string to be tested for word frequency */
    var origString = "dog jumping again jumping again jumping again jumping over dog"

    /* Map to hold the word count */
    var wordFreqMap = scala.collection.immutable.SortedMap.empty[String, AtomicInteger]

    /* Convert String to array */
    var origStringAsArr = origString.split("\\s+")

    println("Array length : " + origStringAsArr.length)

    /* Iterate over string array */
    for (i <- 0 to origStringAsArr.length - 1) {

      /* Only for valid string */
      if (origStringAsArr(i) != null && !"".equalsIgnoreCase(origStringAsArr(i))) {

        /* Increment the count of string, if found in Map */
        if (wordFreqMap.contains(origStringAsArr(i).trim())) {

          /* Increment the value on key */
          wordFreqMap.get(origStringAsArr(i)).get.incrementAndGet();
        } else {

          /* Store '1' count of string, if not found in Map */
          wordFreqMap += origStringAsArr(i) -> new AtomicInteger(1)
        }
      } else {

        println("Ignored invalid string '" + origStringAsArr(i) + "' at position '" + i + "'");
      }
    }

    println("wordFreqMap : " + wordFreqMap);
  }
}