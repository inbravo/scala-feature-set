package com.inbravo.spark

import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql.SparkSession

/**
 *
 */
object SparkExecutorsTest {

  def main(args: Array[String]) {

    /* To avoid 'winutils.exe' error on windows */
    if (System.getProperty("os.name").toLowerCase.contains("window")) {
      System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
    }

    /* Create new local spark session with Single threads per Core */
    val sparkSession = SparkSession.builder.config(new SparkConf().setAppName("SparkDFTest").setMaster("local[*]"))
      .getOrCreate

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    /* Create a DataFrame from JSON */
    val df = sparkSession.read.json("src/main/resources/people.json")

    /* Example 1 : Displays the content of the DataFrame */
    println("Complete Data Frame: " + df.show)
    println("-----------------------------------------------------")
 
    /* Example 2 : Displays the partition information */
    println("No of paritions:" + df.rdd.getNumPartitions)
    println("Strcture of paritions:" + df.rdd.glom.collect)
    println("-----------------------------------------------------")
    
  }
}