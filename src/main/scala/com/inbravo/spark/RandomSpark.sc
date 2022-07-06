package com.inbravo.spark

import org.apache.spark.sql.types.{ StructType, StructField, StringType, LongType };
import org.apache.spark.{ SparkContext, SparkConf }
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._

/**
 */
object RandomSpark {

  val intVal: Int = Int.MaxValue                  //> intVal  : Int = 2147483647

  def func: Int = intVal                          //> func: => Int

  val f = func                                    //> f  : Int = 2147483647

  def anotherFunc: Int = { intVal }               //> anotherFunc: => Int

  def anotherOneFunc: Int = { return intVal }     //> anotherOneFunc: => Int

  def anotherSecondFunc = intVal                  //> anotherSecondFunc: => Int

  println("" + func)                              //> 2147483647
}