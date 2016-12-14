package com.inbravo.lang.ref

import java.lang.ref.WeakReference
import java.util.WeakHashMap

/**
 * amit.dixit
 * How a WeakHashMap works
 */
object WeakHashMapTest extends App {

  import java.util.WeakHashMap
  import java.lang.ref.WeakReference

  /* Create a WeakHashMap */
  private val cache = new WeakHashMap[String, WeakReference[String]]()

  for (a <- 0 to 100) {

    /* Usage of 'cache' object is thread safe now */
    cache.synchronized {

      /* Put a new string in cache */
      cache.put(a + "A", new WeakReference(a + "A"))
    }
  }

  /* This loop will print all values in cache */
  for (a <- 0 to 100) {

    /* Put a new string in cache */
    println(cache.get(a + "A").get)
  }

  println("Size of cache before garbage collection: " + cache.size())
  
  /* Garbage collection cycle will flush all cache objects */
  System.gc()
  Thread.sleep(1000)
  
  println("Size of cache a garbage collection: " + cache.size())
  
  /* This loop will throw null pointer error */
  for (a <- 0 to 100) {

    /* Put a new string in cache */
    println(cache.get(a + "A").get)
  }
}