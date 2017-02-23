package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._

/**
 *
 * amit.dixit
 */
object KryoEncodingTest extends App {

  /* To avoid 'winutils.exe' error on windows */
  if (System.getProperty("os.name").toLowerCase.contains("window")) {
    System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
  }

  /* Create new local spark session with Single threads per Core */
  val sparkSession = SparkSession.builder().config(new SparkConf().setAppName("RandomSpark").setMaster("local[*]"))
    .getOrCreate()

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

  /*  Create persons data frame using RDD and Definition */
  val personsDF = sparkSession.read.json("D:/personal/mygithub/scala-src/src/main/resources/map-reduce.json")

  println("Complete Data Frame: ")
  /* Example 1 : Displays the content of the DataFrame */
  personsDF.show
  println("-----------------------------------------------------")

  /* Untyped DataSet Operations */
  println("Schema: ")
  /* Example 2 : Print the schema in a tree format */
  personsDF.printSchema
  println("-----------------------------------------------------")

  personsDF.createOrReplaceTempView("people")

  /* No pre-defined encoders for DataSet[Map[K,V]], define explicitly */
  implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]
  /* Primitive types and case classes can be also defined as */
  /* implicit val stringIntMapEncoder: Encoder[Map[String, Any]] = ExpressionEncoder() */

  /* SQL statements can be run by using the sql methods provided by Spark */
  val teenagersDF = sparkSession.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19")

  /* The columns of a row in the result can be accessed by field index */
  teenagersDF.map(teenager => "Name: " + teenager(0)).show()

  /* Or by field name */
  teenagersDF.map(teenager => "Name: " + teenager.getAs[String]("name")).show

  /* row.getValuesMap[T] retrieves multiple columns at once into a Map[String, T] */
  teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect
}