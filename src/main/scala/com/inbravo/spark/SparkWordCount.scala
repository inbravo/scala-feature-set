package com.inbravo.spark

import org.apache.spark.{ SparkContext, SparkConf }
import com.inbravo.hdfs.HdfsUtils

/**
 * amit.dixit
 */
object SparkWordCount {

  def main(args: Array[String]): Unit = countWords(args)

  def countWords(args: Array[String]) = {

    /* New spark configuration object with Single threads per Core */
    var sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    /* Create new spark context */
    var sc = new SparkContext(sparkConf)

    try {

      println("word count process is started...")

      /* First cleanup the last created result files */
      HdfsUtils.delete(args(1), "hdfs://localhost:9000")

      /* Get text file  */
      val textFile = sc.textFile(args(0))

      /* Process text file */
      val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)

      /* Save result as text file */
      counts.saveAsTextFile(args(1))

    } finally {

      println("word count process is completed...");

      /* Stop the spark context */
      sc.stop()
    }
  }
}