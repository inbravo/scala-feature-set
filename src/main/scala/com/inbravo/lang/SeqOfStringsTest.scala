package com
package inbravo
package lang
/**
 * 	amit.dixit
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

    /* Override the value at index */
    mutableBuffer(0) = "4"

    /* Update value at index */
    mutableBuffer.updated(1, "5")

    println(mutableBuffer)

    val listVal = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

    println(listVal)

    val anotherListVal = 6 :: 7 :: 8 :: Nil

    /* ':::' operator used for merging */
    println(listVal ::: anotherListVal)

    /* Sort the list in reverse order */
    println(append(listVal, anotherListVal).sortWith(_ > _))

    /*  List(1, 2, 3) */
    println(List.range(1, 4))

    /* List(1, 3, 5) */
    println(List.range(1, 7, 2))

    /* List(9, 6, 3) */
    println(List.range(9, 1, -3))

    /* Use currying when invoking it */
    /* List(a, a, a) */
    println(List.fill(3)('a'))

    /* List(India, India) */
    println(List.fill(2)("India"))

    /* With more than one argument in the first argument list, it'll make multidimensional list */
    /* List(List(b, b, b), List(b, b, b)) */
    println(List.fill(2, 3)('b'))

    /*  One list with 5 elements */
    println(List.tabulate(5)(n => n * n))

    /* List(0, 1, 4, 9, 16) : 3 lists with 4 elements */
    println(List.tabulate(3, 4)(_ * _)) 
  }

  /* Implementation of list concatenation */
  def append[T](firstList: List[T], secondList: List[T]): List[T] = firstList match {

    /* If first list is empty */
    case List()    => secondList
    case x :: rest => x :: append(rest, secondList)
  }
}