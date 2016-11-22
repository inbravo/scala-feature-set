package com.inbravo.spark

import org.apache.spark.sql._
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{ SparkContext, SparkConf }
/**
 * This class is going to exhibit OLAP RollUp functionality
 *
 * amit.dixit
 */
class SparkRollUp {

  /**
   * Following method is the core of this class
   */
  def transform(dataframe: DataFrame): DataFrame = {

    try {

      import dataframe.sqlContext.implicits._

      /* DataFrame for RollUp operation */
      dataframe.rollup($"col_name").sum("count").toDF("col_name", "total")

    } finally {

      println("rollup is completed...")
    }
  }

  /**
   * Test for OLAP RollUp function
   */
  def main(args: Array[String]): Unit = {

    /* Create new SparkRollUp object */
    val rollup = new SparkRollUp

    /* Create new Spark SQL context */
    val context = new SQLContext(new SparkContext(new SparkConf().setAppName("SparkRollUp")))

    /* Create new test data frame */
    val dataFrame = context.createDataFrame(Seq((1, "Amit", "Engineering", 36), (2, "Sumit", "Engineering", 35), (3, "Hari", "Engineering", 36), (4, "Ravi", "Engineering", 36), (5, "Raju", "Engineering", 36), (6, "Mani", "Engineering", 30))).toDF("id", "name", "Department", "Age")

    /* Transform the data frame */
    rollup.transform(dataFrame)

    /* Print schema */
    println("========================================")
    dataFrame.printSchema()
    println("========================================")
  }
}
