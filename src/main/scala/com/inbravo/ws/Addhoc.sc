package com.inbravo.ws

object Addhoc {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet


  def testGenericMethod(any: AnyVal) = {  if(Int.MinValue == any) println("--" + any) }
                                                  //> testGenericMethod: (any: AnyVal)Unit

  testGenericMethod(Long.MinValue)
  testGenericMethod(Int.MinValue)                 //> ---2147483648
}