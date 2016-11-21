package com.inbravo.spark

import org.apache.spark.sql._
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{ SparkContext, SparkConf }
/**
 * This class is going to exhibit OLAP RollUp functionality
 *
 * amit.dixit
 */
class SparkRollUpProcess {

  /* Variable for aggregation */
  var sumTempZero: Long = 0L

  /* Create new Spark SQL context */
  val context = new HiveContext(new SparkContext(new SparkConf().setAppName("SparkRollUpProcess")))

  /**
   * Following method is the core of this class
   */
  def rollup(tableName: String, countColumnName: String): RollUpOutput = {

    /* Output object */
    val output = new RollUpOutput

    try {

      /* DataFrame for RollUp operation */
      val dataFrame = context.sql("FROM " + tableName+" SELECT * ")

      /* Use this as output DataFrame */
      output.dataFrame = dataFrame.asInstanceOf

      /* Get column count from DataFrame */
      val columnCount: Int = output.dataFrame.columns.length

      /* Get 'Count' column value */
      val count: Int = columnCount + output.dataFrame.col(countColumnName).asInstanceOf[Int]

      /* Get the aggregated sum */
      this.sumTempZero = this.sumTempZero + count

      /* Print the output frame */
      println("RollUp resulted : " + this.sumTempZero)

      /* Generate output reports */
      finalize(tableName, output, count)

    } finally {

      println("rollup is completed...")
    }

    return output
  }

  /**
   * Following method is to build the RollUp output
   */
  def finalize(tableName: String, output: RollUpOutput, count: Int): Array[RollUpOutput] = {

    /* Get all columns */
    val columns: Array[String] = output.dataFrame.columns

    /* Create output array */
    val outputArray = new Array[RollUpOutput](columns.length)

    /* Get all column/values */
    for (n <- columns) {

      output.columnName = n
      output.columnValue = output.dataFrame.col(output.columnName).asInstanceOf[String]
      output.count = count
    }

    /* Generate table */
    this.generateTable(tableName, outputArray)

    return outputArray
  }

  /**
   *
   *  Generate RollUp data in a table
   */
  def generateTable(tableName: String, outputArray: Array[RollUpOutput]) {

    /* Create new output table */
    context.sql("CREATE TABLE IF NOT EXISTS " + tableName + "_OUT(COUNT INT, COLUMN_NAME STRING, COLUMN_VALUE STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'")

    for (n <- outputArray) {

      /* Insert data in output table */
      context.sql("INSERT INTO " + tableName + "_OUT(COUNT, COLUMN_NAME, COLUMN_VALUE) VALUES(" + n.count + "," + n.columnName + "," + n.columnValue + ")")
    }
  }

  /**
   * Test for OLAP RollUp function
   */
  def start(args: Array[String]): Unit = {

    /* Create RollUpVars and Call RollUp */
    var rollUpVars: RollUpOutput = rollup(args(0), args(1))

    /* Print the output frame */
    println(rollUpVars)
  }
}

/**
 *  This is the trait to withhold all RollUp program variables
 */
class RollUpOutput {

  /* Variable for final output table */
  var dataFrame: DataFrame = null

  /* Variable for final output table */
  var columnName: String = null

  /* Variable for final output table */
  var columnValue: String = null

  /* Output of aggregation */
  var count: Long = 0L

  def print() = { println(dataFrame.printSchema()) }
}

object SparkRollUpTest {

  /**
   * Test for OLAP RollUp function
   */
  def main(args: Array[String]): Unit = {

    val rollup = new SparkRollUpProcess

    println("Usage: RollUp works around a Column of given Table")
    println("Usage: First parameter is Table name and second parameter is Column name")
    rollup.start(args)
  }
}