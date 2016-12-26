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

    commaSeparatedDataTest(sparkSession)
    jsonDataTest(sparkSession)
  }

  private def commaSeparatedDataTest(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create an RDD of Person objects from a text file, convert it to a DataFrame */
    val personDF = sparkSession.sparkContext.textFile("src/main/resources/people.txt").map(_.split(",")).map(attributes => Person(attributes(0), attributes(1).trim.toInt)).toDF()

    /* Example 1 : Print schema */
    personDF.printSchema
    println("-----------------------------------------------------")

    /* Example 2 : Print data in DF */
    personDF.foreach { person => println(person) }
    println("-----------------------------------------------------")

    /* Example 3 : Print data in DF without duplicates */
    personDF.dropDuplicates.foreach { person => println(person) }
    println("-----------------------------------------------------")

    println("Only column(name): ")
    /* Example 4 : Select a column */
    personDF.select("name").show
    println("-----------------------------------------------------")

    println("Show all but increment the age: ")
    /* Example 5 : Select everybody, but increment the age by 1 */
    personDF.select($"name", $"age" + 1).show
    println("-----------------------------------------------------")

    println("people older than 21: ")
    /* Example 6 : Select people older than 21 */
    personDF.filter($"age" > 21).show
    println("-----------------------------------------------------")

    println("People with valid name and age more than 21: ")
    /* Example 7 : Select people with not null name, older than 21 */
    personDF.filter($"age" > 21).filter($"name".isNotNull).show
    println("-----------------------------------------------------")

    println("Count all people in same age group: ")
    /* Example 8 : Count people by age */
    personDF.filter($"age".isNotNull).groupBy("age").count.show
    println("-----------------------------------------------------")

    /* Example 9 : Print sum of all persons age */
    println("Sum of all persons ages: " + personDF.dropDuplicates.select($"age").rdd.map(_(0).asInstanceOf[Long]).reduce(_ + _))
    println("-----------------------------------------------------")
  }

  private def jsonDataTest(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create a DataFrame from JSON */
    val personDF = sparkSession.read.json("src/main/resources/people.json")

    println("Complete Data Frame: ")
    /* Example 1 : Displays the content of the DataFrame */
    personDF.show
    println("-----------------------------------------------------")

    /* Untyped DataSet Operations */
    println("Schema: ")
    /* Example 2 : Print the schema in a tree format */
    personDF.printSchema
    println("-----------------------------------------------------")

    println("Only column(name): ")
    /* Example 3 : Select a column */
    personDF.select("name").show
    println("-----------------------------------------------------")

    println("Show all but increment the age: ")
    /* Example 4 : Select everybody, but increment the age by 1 */
    personDF.select($"name", $"age" + 1).show
    println("-----------------------------------------------------")

    println("people older than 21: ")
    /* Example 5 : Select people older than 21 */
    personDF.filter($"age" > 21).show
    println("-----------------------------------------------------")

    println("People with valid name and age more than 21: ")
    /* Example 6 : Select people with not null name, older than 21 */
    personDF.filter($"age" > 21).filter($"name".isNotNull).show
    println("-----------------------------------------------------")

    println("Count all people in same age group: ")
    /* Example 7 : Count people by age */
    personDF.filter($"age".isNotNull).groupBy("age").count.show
    println("-----------------------------------------------------")

    /* Example 8 : Print sum of all persons age */
    println("Sum of all persons ages: " + personDF.dropDuplicates.select($"age").rdd.map(_(0).asInstanceOf[Long]).reduce(_ + _))
    println("-----------------------------------------------------")
  }
}