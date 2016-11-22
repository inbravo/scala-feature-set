package com.inbravo.spark

import org.apache.spark.rdd._
import org.apache.spark.sql._
import org.apache.spark.sql.types.{ StructType, StructField, StringType, IntegerType };
import org.apache.spark.{ SparkContext, SparkConf }

/**
 *
 */
object DataFrameTest {

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
  val empSeq = Seq(Row(1, "Amit", "Engineering", 36, 5),
    Row(2, "Sumit", "Engineering", 35, 5),
    Row(3, "Hari", "Engineering", 36, 5),
    Row(4, "Ravi", "Engineering", 36, 5),
    Row(5, "Raju", "Engineering", 36, 5),
    Row(6, "Mani", "Engineering", 30, 5))

  /* Rows of employees */
  val empRow = Row.fromSeq(empSeq)

  def main(args: Array[String]): Unit = {

    createDataFrame()
  }

  /**
   * Create a DataFrame
   */
  def createDataFrame() {

    /* Create new spark context */
    val sparkContext = new SparkContext(new SparkConf().setAppName("SparkRollUp"))

    /* Create new Spark SQL context */
    val sqlContext = new SQLContext(sparkContext)

    /* This is used to implicitly convert an RDD to a DataFrame */
    import sqlContext.implicits._

    /* Create employee RDD */
    val empRDD = sparkContext.parallelize(empSeq)

    /* Example 1 : Create empty data frame using Schema only */
    val emptyDataFrame: DataFrame = sqlContext.createDataFrame(sparkContext.emptyRDD[Row], empSchema)

    /*  Example 2 : Create a employees data frame using RDD and Schema */
    val employeesDataFrame: DataFrame = sqlContext.createDataFrame(empRDD, empSchema)

    /* Print schema */
    println("========================================")
    emptyDataFrame.printSchema()
    employeesDataFrame.printSchema()
    println("========================================")
  }
}