package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql._

/**
 * This is a test of all DataSet functions
 *
 * amit.dixit
 */

object SparkDSTest {

  /* Case classes to represent a business object  */
  case class Person(name: String, age: Long)

  /* Schema of Person */
  val personSchema = StructType(Seq(StructField("name", StringType, nullable = true), StructField("age", LongType, nullable = true)))

  /* A list of persons */
  val persons = Seq(Person("Amit", 20), Person("Anuj", 30), Person("Aniket", 25), Person("Arihant", 45), Person("Avirat", 75), Person("Avishi", 35))

  def main(args: Array[String]): Unit = {

    /* To avoid 'winutils.exe' error on windows */
    if (System.getProperty("os.name").toLowerCase.contains("window")) {
      System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
    }

    /* (local[*]) automatically identify the number of cores in system */
    val sparkSession = SparkSession.builder().config(new SparkConf().setAppName("SparkDSTest").setMaster("local[*]"))
      .getOrCreate()

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    runDatasetCreationExample(sparkSession)
  }

  private def runDatasetCreationExample(sparkSession: SparkSession): Unit = {

    /*  Encoders for most common types are automatically provided by importing sqlContext.implicits._ */
    import sparkSession.implicits._

    println("Persons as data set: ")
    persons.toDS().show()
    println("-----------------------------------------------------")

    val personDS = Seq(Person("Andy", 32)).toDS()
    personDS.show()
    println("-----------------------------------------------------")

    /* DataFrames can be converted to a DataSet by providing a class. Mapping will be done by name */
    sparkSession.read.json("src/main/resources/people.json").as[Person].show
    println("-----------------------------------------------------")
  }
}