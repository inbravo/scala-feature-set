package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._

/**
 */
object RandomSpark {

  /* To avoid 'winutils.exe' error */
  System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
                                                  //> res0: String = null

  /* Create new local spark session with Single threads per Core */
  val sparkSession = SparkSession.builder().config(new SparkConf().setAppName("RandomSpark").setMaster("local[*]"))
    .getOrCreate()                                //> Using Spark's default log4j profile: org/apache/spark/log4j-defaults.propert
                                                  //| ies
                                                  //| 17/01/04 17:23:20 INFO SparkContext: Running Spark version 2.0.2
                                                  //| 17/01/04 17:23:21 WARN NativeCodeLoader: Unable to load native-hadoop librar
                                                  //| y for your platform... using builtin-java classes where applicable
                                                  //| 17/01/04 17:23:21 INFO SecurityManager: Changing view acls to: amit.dixit
                                                  //| 17/01/04 17:23:21 INFO SecurityManager: Changing modify acls to: amit.dixit
                                                  //| 
                                                  //| 17/01/04 17:23:21 INFO SecurityManager: Changing view acls groups to: 
                                                  //| 17/01/04 17:23:21 INFO SecurityManager: Changing modify acls groups to: 
                                                  //| 17/01/04 17:23:21 INFO SecurityManager: SecurityManager: authentication disa
                                                  //| bled; ui acls disabled; users  with view permissions: Set(amit.dixit); group
                                                  //| s with view permissions: Set(); users  with modify permissions: Set(amit.dix
                                                  //| it); groups with modify permissions: Set()
                                                  //| 17/01/04 17:23:22 INFO Utils: Successfully started service 'sparkDriver' 
                                                  //| Output exceeds cutoff limit.

  /* Change log level to avoid lots of log */
  sparkSession.sparkContext.setLogLevel("ERROR")

  /* Print the spark version */
  println("Spark version: " + sparkSession.sparkContext.version)
                                                  //> Spark version: 2.0.2

  /* Schema of Person */
  val personSchema = StructType(Seq(StructField("name", StringType, nullable = true), StructField("age", LongType, nullable = true)))
                                                  //> personSchema  : org.apache.spark.sql.types.StructType = StructType(StructFie
                                                  //| ld(name,StringType,true), StructField(age,LongType,true))

  /* Case classes to represent a business object  */
  case class Person(name: String, age: Long)

  /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
  import sparkSession.implicits._

  /*  Create persons data frame using RDD and Definition */
  val personsDF = sparkSession.read.json("D:/personal/mygithub/scala-src/src/main/resources/map-reduce.json")
                                                  //> personsDF  : org.apache.spark.sql.DataFrame = [age: bigint, name: string]

  println("Complete Data Frame: ")                //> Complete Data Frame: 
  /* Example 1 : Displays the content of the DataFrame */
  personsDF.show                                  //> +---+----+
                                                  //| |age|name|
                                                  //| +---+----+
                                                  //| | 30|   A|
                                                  //| | 30|   B|
                                                  //| | 19|   C|
                                                  //| | 49|   D|
                                                  //| | 79|   E|
                                                  //| | 79|   F|
                                                  //| | 79|   G|
                                                  //| | 39|   H|
                                                  //| | 30|   I|
                                                  //| | 30|   J|
                                                  //| | 19|   K|
                                                  //| | 49|   L|
                                                  //| | 79|   M|
                                                  //| | 79|   N|
                                                  //| | 79|   O|
                                                  //| | 39|   P|
                                                  //| | 12|   Q|
                                                  //| | 32|   R|
                                                  //| | 33|   S|
                                                  //| | 34|   T|
                                                  //| +---+----+
                                                  //| only showing top 20 rows
                                                  //| 
  println("-----------------------------------------------------")
                                                  //> -----------------------------------------------------

  /* Untyped DataSet Operations */
  println("Schema: ")                             //> Schema: 
  /* Example 2 : Print the schema in a tree format */
  personsDF.printSchema                           //> root
                                                  //|  |-- age: long (nullable = true)
                                                  //|  |-- name: string (nullable = true)
                                                  //| 
  println("-----------------------------------------------------")
                                                  //> -----------------------------------------------------

  personsDF.createOrReplaceTempView("people")
  
  /* No pre-defined encoders for Dataset[Map[K,V]], define explicitly */
  implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]
                                                  //> mapEncoder  : org.apache.spark.sql.Encoder[Map[String,Any]] = class[value[0
                                                  //| ]: binary]
  /* Primitive types and case classes can be also defined as */
  /* implicit val stringIntMapEncoder: Encoder[Map[String, Any]] = ExpressionEncoder() */

  /* SQL statements can be run by using the sql methods provided by Spark */
  val teenagersDF = sparkSession.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19")
                                                  //> teenagersDF  : org.apache.spark.sql.DataFrame = [name: string, age: bigint]
                                                  //| 

  /* The columns of a row in the result can be accessed by field index */
  teenagersDF.map(teenager => "Name: " + teenager(0)).show
                                                  //> +-------+
                                                  //| |  value|
                                                  //| +-------+
                                                  //| |Name: C|
                                                  //| |Name: K|
                                                  //| +-------+
                                                  //| 

  /* Or by field name */
  teenagersDF.map(teenager => "Name: " + teenager.getAs[String]("name")).show
                                                  //> +-------+
                                                  //| |  value|
                                                  //| +-------+
                                                  //| |Name: C|
                                                  //| |Name: K|
                                                  //| +-------+
                                                  //| 

  /* row.getValuesMap[T] retrieves multiple columns at once into a Map[String, T] */
  val teenagersMap = teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect
                                                  //> teenagersMap  : Array[Map[String,Any]] = Array(Map(name -> C, age -> 19), M
                                                  //| ap(name -> K, age -> 19))
}