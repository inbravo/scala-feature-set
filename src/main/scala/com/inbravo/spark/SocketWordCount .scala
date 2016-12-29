package com.inbravo.spark

import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._

/**
 * Program to count words, received on socket
 *
 * On Unix: nc -lk 9090
 * On window: nc -l -p 9090
 *
 * amit.dixit
 */
object SocketWordCount {

  def main(args: Array[String]): Unit = {

    /* To avoid 'winutils.exe' error */
    System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");

    /* Create the context with Single threads per Core listening per second batch interval */
    val streamingContext = new StreamingContext(new SparkConf().setAppName("SparkDSTest").setMaster("local[*]"), Seconds(1))

    /* Print the spark version */
    println("Spark version: " + streamingContext.sparkContext.version)

    /* Set checkpoint */
    streamingContext.checkpoint(".")

    /* Change log level to avoid lots of log */
    streamingContext.sparkContext.setLogLevel("ERROR")

    /* Start listening thread */
    startListening(streamingContext, args)
  }

  private def startListening(streamingContext: StreamingContext, args: Array[String]): Unit = {
    println("startListening....")

    /* Create a ReceiverInputDStream on target ip:port using TCP socket */
    val lines = streamingContext.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_ONLY)

    /* Split every line by space char */
    val words = lines.flatMap(_.split(" "))

    /* Count the words */
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)

    /* Prints the first ten elements of every batch of data in DStream */
    wordCounts.print
    streamingContext.start
    streamingContext.awaitTermination
  }
}