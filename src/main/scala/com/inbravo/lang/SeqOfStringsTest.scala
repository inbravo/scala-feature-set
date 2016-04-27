package com
package inbravo
package lang
/**
 *
 */
object SeqOfStringsTest {

  def main(args: Array[String]): Unit = {

    /* Seq is the default trait for ordered sequences */
    var list: Seq[String] = List("1")

    /* Vector is the best default implementation. It has practically constant time access and modification, yet is totally immutable, and shares most of its structure */
    /* The companion object of Vector (as with all of the collections) defines an apply() factory method, which will return an efficient implementation for the size you have chosen */
    val secondList: Seq[String] = Vector("10")

    /* These operations return new lists, without modifying the old ones */
    /* '+:'  means prepend */
    list = list :+ "2"

    println(list)

    /* ':+'  means append */
    list = "3" +: list

    println(list)

    /* Add All using '++'*/
    println(list ++ secondList)

    /* ArrayBuffer */
    val mutableArrayBuffer: scala.collection.mutable.Seq[String] = scala.collection.mutable.ArrayBuffer("hello", "world")

    println(mutableArrayBuffer)

    val mutableBuffer: scala.collection.mutable.Buffer[String] = scala.collection.mutable.ArrayBuffer("hello", "world")
    mutableBuffer(0) = "4"

    println(mutableBuffer)
  }
}