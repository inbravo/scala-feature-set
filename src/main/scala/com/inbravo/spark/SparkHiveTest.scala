package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql._

/**
 * amit.dixit
 *
 */
object SparkHiveTest {

  def main(args: Array[String]): Unit = {

    /* To avoid 'winutils.exe' error on windows */
    if (System.getProperty("os.name").toLowerCase.contains("window")) {
      System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
    }

    /* Create new local spark session with Single threads per Core and hive support enabled */
    val sparkSession = SparkSession.builder.config(new SparkConf().set("hive.metastore.uris", "thrift://192.168.218.154:10000").setAppName("SparkHiveTest").setMaster("local[*]")).enableHiveSupport
      .getOrCreate

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    /* Run hive query */
    runHiveQuery(sparkSession)

    try {
      Thread.sleep(5000000)

    } catch {

      /* Check for thread exception cases */
      case e: InterruptedException => e.printStackTrace()

    } finally {
      println("done")
    }
  }

  /**
   *
   */
  private def runHiveQuery(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create an arbitrary frame */
    val frame = Seq(("one", 1), ("two", 2), ("three", 3)).toDF("word", "count")

    /* See the frame created */
    frame.show()
    /**
     * +-----+-----+
     * | word|count|
     * +-----+-----+
     * |  one|    1|
     * |  two|    2|
     * |three|    3|
     * +-----+-----+
     */

    /* Write the frame */
    frame.write.mode("overwrite").saveAsTable("t4")
    println("-----------------------------------------------------")
  }
}