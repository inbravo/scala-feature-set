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
}