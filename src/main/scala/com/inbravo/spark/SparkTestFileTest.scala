package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql._
/**
 * Playing with file input
 * amit.dixit
 */
object SparkTestFileTest {

  /* Case classes to represent a business object  */
  case class Person(name: String, age: Long)

  /* Schema of Person */
  val personSchema = StructType(Seq(StructField("name", StringType, nullable = true), StructField("age", LongType, nullable = true)))

  /* A list of persons */
  val persons = Seq(Row("Amit", 20L), Row("Anuj", 30L), Row("Aniket", 25L), Row("Arihant", 45L), Row("Avirat", 75L), Row("Avishi", 35L))

  def main(args: Array[String]): Unit = {

    /* To avoid 'winutils.exe' error */
    System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");

    /* Create new local spark session */
    val sparkSession = SparkSession.builder().config(new SparkConf().setAppName("SparkTestFileTest").setMaster("local"))
      .getOrCreate()

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    runFileTest(sparkSession)
  }

  private def runFileTest(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create an RDD of Person objects from a text file, convert it to a DataFrame */
    val personDF = sparkSession.sparkContext.textFile("src/main/resources/people.txt").map(_.split(",")).map(attributes => Person(attributes(0), attributes(1).trim.toInt)).toDF()

    /* Print schema */
    personDF.printSchema()
    println("-----------------------------------------------------")

    /* Print data in DF */
    personDF.foreach { person => println(person) }
    println("-----------------------------------------------------")

    /* Print data in DF without duplicates */
    personDF.dropDuplicates.foreach { person => println(person) }
    println("-----------------------------------------------------")

    /* Print sum of all persons age */
    println("Sum of all persons ages: " + personDF.dropDuplicates.select($"age").rdd.map(_(0).asInstanceOf[Long]).reduce(_ + _))
    println("-----------------------------------------------------")
  }
}