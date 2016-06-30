package com.inbravo.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 *
 */
class ScalaWordCount {

  def main(args: Array[String]): Unit = countWords(args)

  def countWords(args: Array[String]) = {

    var sparkConf = new SparkConf().setAppName("ScalaWordCount")

    /* Create new spark context */
    var sc = new SparkContext(sparkConf)

    /* Get text file  */
    val textFile = sc.textFile(args(0))

    /* Process text file */
    val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)

    /* Save result as text file */
    counts.saveAsTextFile(args(1))
  }
}