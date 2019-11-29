package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql.SparkSession
/**
 * Following program demonstrates various types of implicit encoding nativerly provided by Spark
 *
 *  amit.dixit
 */
object ImplicitEncodingTest {

  def main(args: Array[String]): Unit = {

    /* To avoid 'winutils.exe' error on windows */
    if (System.getProperty("os.name").toLowerCase.contains("window")) {
      System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
    }

    /* Create new local spark session with Single threads per Core */
    val sparkSession = SparkSession.builder().config(new SparkConf().setAppName("RandomSpark").setMaster("local[*]"))
      .getOrCreate

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    /* Schema of Person */
    val personSchema = StructType(Seq(StructField("name", StringType, nullable = true), StructField("age", LongType, nullable = true)))

    /* Case classes to represent a business object  */
    case class Person(name: String, age: Long)

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create a DataFrame from JSON */
    val df = sparkSession.read.json("src/main/resources/people.json")

    println("Schema: ")
    /* Example 1 : Displays the schema of the DataFrame */
    df.printSchema
    println("-----------------------------------------------------")

    println("Only column(name): ")
    /* Example 2 : Select all columns */
    df.select("name").show
    println("-----------------------------------------------------")

    println("Only column(name): ")
    /* Example 3 : Select a column */
    df.select("name").show
    println("-----------------------------------------------------")

    println("Show all but increment the age: ")
    /* Example 4 : Select everybody, but increment the age by 1 */
    df.select($"name", $"age" + 1).show
    println("-----------------------------------------------------")

    println("people older than 21: ")
    /* Example 5 : Select people older than 21 */
    df.filter($"age" > 21).show
    println("-----------------------------------------------------")

    println("People with valid name and age more than 21: ")
    /* Example 6 : Select people with not null name, older than 21 */
    df.filter($"age" > 21).filter($"name".isNotNull).show
    println("-----------------------------------------------------")

    println("Count all people in same age group: ")
    /* Example 7 : Count people by age */
    df.filter($"age".isNotNull).groupBy("age").count.show
    println("-----------------------------------------------------")

    /* Example 8 : Register the DataFrame as a SQL temporary view, valid only for current session */
    df.createOrReplaceTempView("people")
    sparkSession.sql("SELECT * FROM people").show
    println("-----------------------------------------------------")
  }
}