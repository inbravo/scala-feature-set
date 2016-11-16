package com.inbravo.s99

/* These are the default includes in every Scala class/object */
/*  _root_ denotes an absolute path */
import _root_.java.lang._
import _root_.scala._
import _root_.scala.Predef._

/**
 * amit.dixit
 * Find the last element in list
 */
object LastElementInList {

  def main(args: Array[String]) = {

    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    /* Last element is */
    println(lastByInbuiltOne(list))
    println(lastByInbuiltTwo(list))
    println(lastByRecursive(list))
  }

  def lastByInbuiltOne(list: List[Int]) = {

    /* Last element is */
    list.last
  }

  def lastByInbuiltTwo(list: List[Int]) = {

    /* Last element is */
    list(list.size - 1)
  }

  /* Find last element recursively */
  def lastByRecursive[A](list: List[A]): A = list match {

    case h :: Nil  => h
    case _ :: tail => lastByRecursive(tail)
    case _         => throw new NoSuchElementException
  }
}
