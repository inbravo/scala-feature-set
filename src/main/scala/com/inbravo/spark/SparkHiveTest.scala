package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql._

/**
 * amit.dixit
 *
 * Start hive meta service: 'hive --service metastore'
 */
object SparkHiveTest {

  def main(args: Array[String]): Unit = {

    /* To avoid 'winutils.exe' error on windows */
    if (System.getProperty("os.name").toLowerCase.contains("window")) {
      System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
    }

    /* Create Spark config */
    val sparkConf = new SparkConf()
      .set("hive.metastore.uris", "thrift://192.168.218.154:9083")
      .set("spark.sql.warehouse.dir", "/apps/hive/warehouse")
      .set("deploy-mode", "cluster")
      .set("spark.logConf", "true")
      .set("spark.dynamicAllocation.enabled", "true")
      .set("fs.hdfs.impl", classOf[org.apache.hadoop.hdfs.DistributedFileSystem].getName)
      .set("fs.file.impl", classOf[org.apache.hadoop.fs.LocalFileSystem].getName)
      .set("spark.sql.crossJoin.enabled", "true")

    /* Create new local spark session with single threads per Core and hive support enabled */
    val sparkSession = SparkSession.builder.config(sparkConf.setAppName("SparkHiveTest").setMaster("local[*]")).enableHiveSupport.getOrCreate

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    /* Run hive create table query */
    runCreateQuery(sparkSession)

    /* Run hive select table query */
    runSelectQuery(sparkSession)
  }

  /**
   *
   */
  private def runCreateQuery(sparkSession: SparkSession): Unit = {

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
    frame.write.mode("overwrite").saveAsTable("T6")
    println("-----------------------------------------------------")
  }

  /**
   *
   */
  private def runSelectQuery(sparkSession: SparkSession): Unit = {

    /* Execute a select query */
    val codeDF = sparkSession.sql("SELECT * FROM T6")

    /* Write the frame */
    val list = codeDF.collectAsList()
    println("-----------------------------------------------------")
  }
}
