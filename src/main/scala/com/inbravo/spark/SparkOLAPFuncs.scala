package com.inbravo.spark

import org.apache.spark.rdd._
import org.apache.spark.sql._
import org.apache.spark.sql.types.{ StructType, StructField, StringType, IntegerType };
import org.apache.spark.{ SparkContext, SparkConf }

/**
 *
 */
object TestOLAPFuncs {

  /* A case class to represent a business object  */
  case class Employee(id: Int, name: String, dept: String, age: Int, Exp: Int)

  /* Schema of Employee object */
  val empSchema = StructType(Seq(
    StructField("id", IntegerType, nullable = false),
    StructField("name", StringType, nullable = false),
    StructField("dept", StringType, nullable = false),
    StructField("age", IntegerType, nullable = false),
    StructField("exp", IntegerType, nullable = false)))

  /* A list of employees */
  val empSeq = Seq((1, "Amit", "Engineering", 36, 5),
    (2, "Sumit", "Engineering", 35, 5),
    (3, "Hari", "Engineering", 36, 5),
    (4, "Ravi", "Engineering", 36, 5),
    (5, "Raju", "Engineering", 36, 5),
    (6, "Mani", "Engineering", 30, 5))

  def main(args: Array[String]): Unit = {

    testRollUp()
    testAggregation()
  }

  /**
   * Test for OLAP RollUp function
   *
   * Find total years of experience of all employees, from same age group
   */
  def testRollUp() {

    /* Create new SparkRollUp object */
    val rollup = new com.inbravo.spark.SparkRollUp

    /* Create new spark context */
    val sparkContext = new SparkContext(new SparkConf().setAppName("SparkRollUp"))

    /* Create new Spark SQL context */
    val sqlContext = new SQLContext(sparkContext)

    /* This is used to implicitly convert an RDD to a DataFrame */
    import sqlContext.implicits._

    /* Create employee RDD */
    val empRDD = sparkContext.parallelize(empSeq)

    /* Create new test data frame */
    val dataFrame: DataFrame = empRDD.toDF()

    /* Transform the data frame */
    rollup.transform(dataFrame)

    /* Print schema */
    println("========================================")
    dataFrame.printSchema()
    println("========================================")
  }

  /**
   * Test for OLAP Aggregation function
   *
   * Find total years of experience of all employees, from same age group
   */
  def testAggregation() {

    /* Create new SparkAggregation object */
    val aggregation = new com.inbravo.spark.SparkAggregation

    /* Create new spark context */
    val sparkContext = new SparkContext(new SparkConf().setAppName("SparkRollUp"))

    /* Create new Spark SQL context */
    val sqlContext = new SQLContext(sparkContext)

    /* This is used to implicitly convert an RDD to a DataFrame */
    import sqlContext.implicits._

    /* Create employee RDD */
    val empRDD = sparkContext.parallelize(empSeq)

    /* Create new test data frame */
    val dataFrame: DataFrame = empRDD.toDF()

    /* Transform the data frame */
    aggregation.transform(dataFrame)

    /* Print schema */
    println("========================================")
    dataFrame.printSchema()
    println("========================================")
  }
}

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