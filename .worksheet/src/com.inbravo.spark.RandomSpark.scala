package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._

/**
 */
object RandomSpark {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(434); val res$0 = 

  /* To avoid 'winutils.exe' error */
  System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");System.out.println("""res0: String = """ + $show(res$0));$skip(204); ;

  /* Create new local spark session with Single threads per Core */
  val sparkSession = SparkSession.builder().config(new SparkConf().setAppName("RandomSpark").setMaster("local[*]"))
    .getOrCreate();System.out.println("""sparkSession  : org.apache.spark.sql.SparkSession = """ + $show(sparkSession ));$skip(96); 

  /* Change log level to avoid lots of log */
  sparkSession.sparkContext.setLogLevel("ERROR");$skip(98); 

  /* Print the spark version */
  println("Spark version: " + sparkSession.sparkContext.version);$skip(160); 

  /* Schema of Person */
  val personSchema = StructType(Seq(StructField("name", StringType, nullable = true), StructField("age", LongType, nullable = true)))

  /* Case classes to represent a business object  */
  case class Person(name: String, age: Long)

  /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
  import sparkSession.implicits._;System.out.println("""personSchema  : org.apache.spark.sql.types.StructType = """ + $show(personSchema ));$skip(418); 

  /*  Create persons data frame using RDD and Definition */
  val personsDF = sparkSession.read.json("D:/personal/mygithub/scala-src/src/main/resources/map-reduce.json");System.out.println("""personsDF  : org.apache.spark.sql.DataFrame = """ + $show(personsDF ));$skip(36); 

  println("Complete Data Frame: ");$skip(75); 
  /* Example 1 : Displays the content of the DataFrame */
  personsDF.show;$skip(67); 
  println("-----------------------------------------------------");$skip(58); 

  /* Untyped DataSet Operations */
  println("Schema: ");$skip(78); 
  /* Example 2 : Print the schema in a tree format */
  personsDF.printSchema;$skip(67); 
  println("-----------------------------------------------------");$skip(47); 

  personsDF.createOrReplaceTempView("people");$skip(157); 
  
  /* No pre-defined encoders for Dataset[Map[K,V]], define explicitly */
  implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]];System.out.println("""mapEncoder  : org.apache.spark.sql.Encoder[Map[String,Any]] = """ + $show(mapEncoder ));$skip(329); 
  /* Primitive types and case classes can be also defined as */
  /* implicit val stringIntMapEncoder: Encoder[Map[String, Any]] = ExpressionEncoder() */

  /* SQL statements can be run by using the sql methods provided by Spark */
  val teenagersDF = sparkSession.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19");System.out.println("""teenagersDF  : org.apache.spark.sql.DataFrame = """ + $show(teenagersDF ));$skip(134); 

  /* The columns of a row in the result can be accessed by field index */
  teenagersDF.map(teenager => "Name: " + teenager(0)).show;$skip(104); 

  /* Or by field name */
  teenagersDF.map(teenager => "Name: " + teenager.getAs[String]("name")).show;$skip(192); 

  /* row.getValuesMap[T] retrieves multiple columns at once into a Map[String, T] */
  val teenagersMap = teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect;System.out.println("""teenagersMap  : Array[Map[String,Any]] = """ + $show(teenagersMap ))}
}
