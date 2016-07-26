package com.inbravo.lang

import scala.collection.mutable.HashMap
/**
 *
 */
object MapTest {

  /* Methods are introduced with def */
  /* Return type comes after the method */
  /* "=" marks the implementation */
  /* Unit is like void */
  def main(args: Array[String]): Unit = {

    val map = HashMap(1 -> "b", 2 -> "a", 3 -> "c")

    /* Get value on key '1' */
    println(map(1))

    /* Add another key-value in map */
    map + (4 -> "d")

    /* 'println' is defined in scala.Predef, which automatically gets imported */
    println(map)

    /* Crates an immutable map */
    val m = Map("i" -> 1, "ii" -> 2)

    /* Returns Map(i->1, ii->2) */
    m.toString

    /* Adds an entry (returns Map(i->1, ii->2, vi->6) */
    m + ("vi" -> 6)

    /* Removes the entry (returns Map(i->1, vi->6)) */
    m - "ii"

    /* Adds multiple entries */
    m ++ List("iii" -> 5, "v" -> 5)

    /* Removes multiple entries */
    m -- List("i", "ii")

    /* Returns the size of the map */
    m.size

    /* Checks for inclusion */
    m.contains("ii")

    /* Returns 2 */
    m("ii")

    /* Returns iterable over keys ("i" and "ii") */
    m.keys

    /* Returns keys as a set (Set(i, ii)) */
    m.keySet

    /* Returns iterable over values (1, 2) */
    m.values

    /* Indicates whether the map is empty */
    println(m.isEmpty)

    println(m)

    /* Makes the mutable collections easy to access */
    import scala.collection.mutable

    /* Creates an empty, mutable map (HashMap) */
    val w = mutable.Map.empty[String, Int]

    /* Adds an entry (Map(one->1)) */
    w += ("one" -> 1)

    /* Removes an entry (Map()) */
    w -= "one"

    /* Adds multiple entries */
    w ++= List("st" -> 1, "nd" -> 2, "rd" -> 3)

    /* Removes multiple entries */
    w --= List("st", "nd")

    println(w)

    /* Removes all entries */
    w.clear
  }
}