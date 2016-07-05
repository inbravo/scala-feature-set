package com.inbravo.spark

import org.apache.spark.{ SparkContext, SparkConf }

/**
 * amit.dixit
 */
object ScalaWordCount {

  def main(args: Array[String]): Unit = countWords(args)

  def countWords(args: Array[String]) = {

    var sparkConf = new SparkConf().setAppName("ScalaWordCount")

    /* Create new spark context */
    var sc = new SparkContext(sparkConf)

    try {

      /* First cleanup the last created result files */
      setup(args(1))

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

  /**
   * Clean all previous files
   */
  def setup(hdfsFile: String) = {

    /* Get Hadoop configuration */
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI("hdfs://localhost:9000"), hadoopConf)
    try { hdfs.delete(new org.apache.hadoop.fs.Path(hdfsFile), true) } catch { case _: Throwable => { println("Error while deleting Hadoop file") } }
  }
}