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

    /* To avoid 'winutils.exe' error on windows */
    if (System.getProperty("os.name").toLowerCase.contains("window")) {
      System.setProperty("hadoop.home.dir", "D:/opensource/hadoop-2.7.1/winutils");
    }

    /* Create new local spark session with Single threads per Core */
    val sparkSession = SparkSession.builder.config(new SparkConf().setAppName("SparkDFTest").setMaster("local[*]"))
      .getOrCreate

    /* Change log level to avoid lots of log */
    sparkSession.sparkContext.setLogLevel("ERROR")

    /* Print the spark version */
    println("Spark version: " + sparkSession.sparkContext.version)

    /* RUn all examples */
    runSchemaBasedBasicDataFramesExample(sparkSession)
    runJSONBasedBasicDataFramesExample(sparkSession)
    runInferSchemaExample(sparkSession)
    runParquetExample(sparkSession)
  }

  /**
   * Schema based DataFrame operations
   */
  private def runSchemaBasedBasicDataFramesExample(sparkSession: SparkSession): Unit = {

    /* Create persons RDD */
    val personsRDD = sparkSession.sparkContext.parallelize(persons)

    /* Example 1 : Create empty data frame using Schema only */
    val emptyDataFrame: DataFrame = sparkSession.createDataFrame(sparkSession.sparkContext.emptyRDD[Row], personSchema)

    println("Empty Persons Data Frame: ")
    emptyDataFrame.toDF.show
    println("-----------------------------------------------------")

    /*  Example 2 : Create persons data frame using RDD and Schema */
    val personsDataFrame: DataFrame = sparkSession.createDataFrame(personsRDD, personSchema)

    println("Persons Data Frame: ")
    personsDataFrame.toDF.show
    println("-----------------------------------------------------")

    println("Updated Persons Data Frame: ")
    personsDataFrame.union(personsDataFrame).toDF.show
    println("-----------------------------------------------------")
  }

  /**
   * JSON based DataFrame operations
   */
  private def runJSONBasedBasicDataFramesExample(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create a DataFrame from JSON */
    val df = sparkSession.read.json("src/main/resources/people.json")

    println("Complete Data Frame: ")
    /* Example 1 : Displays the content of the DataFrame */
    df.show
    println("-----------------------------------------------------")

    /* Untyped DataSet Operations */
    println("Schema: ")
    /* Example 2 : Print the schema in a tree format */
    df.printSchema
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

  private def runInferSchemaExample(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._

    /* Create an RDD of Person objects from a text file, convert it to a DataFrame */
    val personDF = sparkSession.sparkContext.textFile("src/main/resources/people.txt").map(_.split(",")).map(attributes => Person(attributes(0), attributes(1).trim.toInt)).toDF()

    /* Register the DataFrame as a temporary view */
    personDF.createOrReplaceTempView("people")

    println("All persons: ")
    /* Example 9 : Displays the content of the DataFrame */
    personDF.show
    println("-----------------------------------------------------")

    /* SQL statements can be run by using the spark methods */
    val teenagersDF = sparkSession.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 29")

    println("Person at first position: ")
    /* Example 10 : The columns of a row in the result can be accessed by field index */
    teenagersDF.map(teenager => "Name: " + teenager(0) + ", Age: " + teenager(1)).show
    println("-----------------------------------------------------")

    println("All persons: ")
    /* Example 11 :  or by field name */
    teenagersDF.map(teenager => "Name: " + teenager.getAs[String]("name") + ", Age: " + teenager.getAs[Long]("age")).show()
    println("-----------------------------------------------------")

    /* Define encoder for DataSet[Map[K,V]] */
    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]

    println("All persons: ")
    /* Example 12 : row.getValuesMap[T] retrieves multiple columns at once into a Map[String, T] */
    val selectedPersonsMap = teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect()
    selectedPersonsMap foreach (person => println(person))
    println("-----------------------------------------------------")
  }

  private def runParquetExample(sparkSession: SparkSession): Unit = {

    /* This import is needed to use the $-notation, for implicit conversions like converting RDDs to DataFrames */
    import sparkSession.implicits._
    import org.apache.commons.io.FileUtils;
    import org.apache.commons.io.filefilter.WildcardFileFilter;

    /* Create an RDD of Person objects from a text file, convert it to a DataFrame */
    val personDF = sparkSession.sparkContext.textFile("src/main/resources/people.txt").map(_.split(",")).map(attributes => Person(attributes(0), attributes(1).trim.toInt)).toDF()

    try {

      /* Delete the parquet directories */
      FileUtils.deleteDirectory(new java.io.File("people.parquet"));
    } catch {
      case e: Exception => println("Exception in deleting file" + e)
    }

    /* DataFrames can be saved as 'PARQUET' files, maintaining the schema information */
    personDF.write.parquet("people.parquet")

    /* The result of loading a PARQUET file is also a DataFrame */
    val parquetFileDF = sparkSession.read.parquet("people.parquet")

    /* PARQUET files can also be used to create a temporary view and then used in SQL statements */
    parquetFileDF.createOrReplaceTempView("parquetFile")
    val namesDF = sparkSession.sql("SELECT name FROM parquetFile WHERE age BETWEEN 13 AND 19")
    namesDF.map(attributes => "Name: " + attributes(0)).show()
    println("-----------------------------------------------------")
  }
}