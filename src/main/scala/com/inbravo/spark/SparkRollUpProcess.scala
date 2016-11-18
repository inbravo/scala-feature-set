package com.inbravo.spark

import org.apache.spark.sql._
import org.apache.spark.{ SparkContext, SparkConf }
/**
 * This class is going to exhibit OLAP RollUp functionality
 *
 * It has a constructor which expects SparkRollUpVars variables
 *
 * amit.dixit
 */
class SparkRollUpProcess(classVars: ClassVars) {

  /* Create new Spark SQL context */
  val sqlContext = new SQLContext(new SparkContext(new SparkConf().setAppName("SparkRollUpTest")));

  /**
   * Following method is the core of this class
   */
  def rollup(rollUpVars: RollUpVars, tableName: String, countColumnName: String): RollUpVars = {

    try {

      /* DataFrame for RollUp operation */
      val dataFrame = sqlContext.sql("SELECT * FROM " + tableName)

      /* Use this as output DataFrame */
      this.classVars.tempDataFrame = dataFrame.asInstanceOf

      /* Get column count from DataFrame */
      val columnCount: Int = this.classVars.tempDataFrame.columns.length

      /* Get 'Count' column value */
      val count: Int = columnCount + this.classVars.tempDataFrame.col(countColumnName).asInstanceOf[Int]

      /* Get the aggregated sum */
      this.classVars.sumTempZero = this.classVars.sumTempZero + count

      /* Print the output frame */
      println("RollUp resulted : " + this.classVars.sumTempZero)

    } finally {

      println("rollup is completed...")
    }

    return rollUpVars
  }

  /**
   * Test for OLAP RollUp function
   */
  def main(args: Array[String]): Unit = {

    /* Create RollUpVars */
    var rollUpVars: RollUpVars = null;

    /* Call RollUp */
    rollUpVars = rollup(rollUpVars, "TABLE_ONE", "COUNT")

    /* Print the output frame */
    println(rollUpVars)
  }
}

/**
 *  This is the core trait to withhold all RollUp program variables
 */
trait ClassVars {

  /* Variable for aggregation */
  var sumTempZero: Long = 0

  /* Variable for final output table */
  var tempDataFrame: DataFrame

  def print() = { println(sumTempZero + " | " + tempDataFrame.printSchema()) }
}

/**
 *  This is the trait to withhold all RollUp program variables
 */
trait RollUpVars {

  /* Variable for final output table */
  var outputDataFrame: DataFrame

  def print() = { println(outputDataFrame.printSchema()) }
}