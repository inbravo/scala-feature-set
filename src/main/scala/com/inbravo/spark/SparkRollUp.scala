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

      /* Step 1: RollUp By 'col_name' */
      /* Step 2: Sum of all 'count' column values  */
      /* Step 3: Rename 'col_name' to 'count' */
      dataframe.rollup($"col_name").sum("count").toDF("col_name", "total")

    } finally {

      println("rollup is completed...")
    }
  }
}
