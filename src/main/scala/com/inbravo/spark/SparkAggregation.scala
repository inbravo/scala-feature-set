package com.inbravo.spark

import org.apache.spark.sql._
import org.apache.spark.{ SparkContext, SparkConf }

/**
 *
 */
class SparkAggregation {

  def transform(dataframe: DataFrame): DataFrame = {

    import dataframe.sqlContext.implicits._

    /* Step 1: Group By 'col_name' */
    /* Step 2: Sum of all 'count' column values  */
    /* Step 3: Rename 'col_name' to 'count' */
    dataframe.groupBy($"col_name").sum("count").toDF("col_name", "total")
  }

  /**
   * Test for OLAP Aggregation function
   */
  def main(args: Array[String]): Unit = {

    /* Create new SparkRollUp object */
    val aggregation = new SparkAggregation

    /* Create new Spark SQL context */
    val context = new SQLContext(new SparkContext(new SparkConf().setAppName("SparkRollUp")))

    /* Create new test data frame */
    val dataFrame = context.createDataFrame(Seq((1, "Amit", "Engineering", 36), (2, "Sumit", "Engineering", 35), (3, "Hari", "Engineering", 36), (4, "Ravi", "Engineering", 36), (5, "Raju", "Engineering", 36), (6, "Mani", "Engineering", 30))).toDF("id", "name", "Department", "Age")

    /* Transform the data frame */
    aggregation.transform(dataFrame)

    /* Print schema */
    println("========================================")
    dataFrame.printSchema()
    println("========================================")
  }
}