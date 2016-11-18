package com.inbravo.spark

import org.apache.spark.sql._
import org.apache.spark.{ SparkContext, SparkConf }
/**
 * This class is going to exhibit OLAP RollUp functionality
 *
 * It has a constructor which expects ClassVars variables
 *
 * amit.dixit
 */
class SparkRollUpProcess(classVars: ClassVars) {

  /* Create new Spark SQL context */
  val sqlContext = new SQLContext(new SparkContext(new SparkConf().setAppName("SparkRollUpProcess")))

  /**
   * Following method is the core of this class
   */
  def rollup(tableName: String, countColumnName: String): RollUpOutput = {

    /* Output object */
    val output = new RollUpOutput

    try {

      /* DataFrame for RollUp operation */
      val dataFrame = sqlContext.sql("SELECT * FROM " + tableName)

      /* Use this as output DataFrame */
      output.dataFrame = dataFrame.asInstanceOf

      /* Get column count from DataFrame */
      val columnCount: Int = output.dataFrame.columns.length

      /* Get 'Count' column value */
      val count: Int = columnCount + output.dataFrame.col(countColumnName).asInstanceOf[Int]

      /* Get the aggregated sum */
      this.classVars.sumTempZero = this.classVars.sumTempZero + count

      /* Print the output frame */
      println("RollUp resulted : " + this.classVars.sumTempZero)

      /* Generate output reports */
      finalize(output, count)

    } finally {

      println("rollup is completed...")
    }

    return output
  }

  /**
   * Following method is to build the RollUp output
   */
  def finalize(output: RollUpOutput, count: Int): Array[RollUpOutput] = {

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
    this.generateTable(outputArray)

    return outputArray
  }

  /* Generate RollUp data in a table */
  def generateTable(outputArray: Array[RollUpOutput]) {

    /* Create new output table */
    sqlContext.sql("CREATE TABLE IF NOT EXISTS ROLLUP_OUT(COUNT INT, COLUMN_NAME STRING, COLUMN_VALUE STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'")

    for (n <- outputArray) {

      /* Insert data in output table */
      sqlContext.sql("INSERT INTO ROLLUP_OUT(COUNT, COLUMN_NAME, COLUMN_VALUE) VALUES(" + n.count + "," + n.columnName + "," + n.columnValue + ")")
    }
  }

  /**
   * Test for OLAP RollUp function
   */
  def main(args: Array[String]): Unit = {

    /* Create RollUpVars */
    var rollUpVars: RollUpOutput = null;

    /* Call RollUp */
    rollUpVars = rollup("ROLLUP_IN", "COUNT")

    /* Print the output frame */
    println(rollUpVars)
  }
}

/**
 *  This is the core trait to withhold all RollUp program variables
 */
trait ClassVars {

  /* Variable for aggregation */
  var sumTempZero: Long

  /* Variable for final output table */
  var tempDataFrame: DataFrame

  def print() = { println(sumTempZero + " | " + tempDataFrame.printSchema()) }
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