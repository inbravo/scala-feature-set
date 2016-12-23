package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql._

/**
 * This is a test of all DataFrame functions
 *
 * amit.dixit
 */
object SparkDFTest {

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
    val sparkSession = SparkSession.builder().config(new SparkConf().setAppName("DataFrameTest").setMaster("local"))
      .getOrCreate()

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    runSchemaBasedBasicDataFramesExample(sparkSession)
    runJSONBasedBasicDataFramesExample(sparkSession)
  }

  private def runSchemaBasedBasicDataFramesExample(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create persons RDD */
    val personsRDD = sparkSession.sparkContext.parallelize(persons)

    /* Example 1 : Create empty data frame using Schema only */
    val emptyDataFrame: DataFrame = sparkSession.createDataFrame(sparkSession.sparkContext.emptyRDD[Row], personSchema)

    /*  Example 2 : Create persons data frame using RDD and Schema */
    val personsDataFrame: DataFrame = sparkSession.createDataFrame(personsRDD, personSchema)

    println("Persons Data Frame: ")
    personsDataFrame.toDF().show()
    println("-----------------------------------------------------")
  }

  /**
   * Basic DataFrame Examples
   */
  private def runJSONBasedBasicDataFramesExample(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create a DataFrame from JSON */
    val df = sparkSession.read.json("src/main/resources/people.json")

    println("Complete Data Frame: ")
    /* Displays the content of the DataFrame */
    df.show()
    println("-----------------------------------------------------")

    /* Untyped DataSet Operations */
    println("Schema: ")
    /* Print the schema in a tree format */
    df.printSchema()
    println("-----------------------------------------------------")

    println("Only column(name): ")
    /* Select a column */
    df.select("name").show()
    println("-----------------------------------------------------")

    println("Show all but increment the age: ")
    /* Select everybody, but increment the age by 1 */
    df.select($"name", $"age" + 1).show()
    println("-----------------------------------------------------")

    println("people older than 21: ")
    /* Select people older than 21 */
    df.filter($"age" > 21).show()
    println("-----------------------------------------------------")

    println("People with valid name and age more than 21: ")
    /* Select people with not null name, older than 21 */
    df.filter($"age" > 21).filter($"name".isNotNull).show()
    println("-----------------------------------------------------")

    println("Count all people in same age group: ")
    /* Count people by age */
    df.filter($"age".isNotNull).groupBy("age").count().show()
    println("-----------------------------------------------------")

    /* Register the DataFrame as a SQL temporary view, valid only for current session */
    df.createOrReplaceTempView("people")
    sparkSession.sql("SELECT * FROM people").show()
    println("-----------------------------------------------------")
  }
}