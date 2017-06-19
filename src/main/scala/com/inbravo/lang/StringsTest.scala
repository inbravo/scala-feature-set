

package com.inbravo.lang

/**
 * How '++' operator is only usefull for Lists merge only
 * 	amit.dixit
 */

object StringsTest {

  def main(args: Array[String]): Unit = {

    /* Two strings */
    val stringOne = "stringOne"
    val stringTwo = "stringTwo"

    /* Two lists */
    val listOne = List("1")
    val listTwo = List("2")

    val contactOperationOne = stringOne + stringTwo
    val contactOperationTwo = stringOne ++ stringTwo

    /* Both values are same */
    if (contactOperationOne.equals(contactOperationTwo)) {
      println("Both operations ('+' & '++') performs similar on strings")
    } else {
      println("Both operations ('+' & '++') performs differently on strings")
    }

    /* Below given line will give compilation error */
    /* val mergectOperationOne = listOne + listTwo */   
    println(listOne ++ listTwo)
    
    val stringToBeSplit = "One,Two,Three,Four,Five" 
    var data = stringToBeSplit.split(",")
    println(data(0))
    println(data(1))
    
  }
}