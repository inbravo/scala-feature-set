package com.inbravo.string

/**
 * A simple program to test, if two given strings are anagram
 * amit.dixit
 */
object Anagram {

  def main(args: Array[String]): Unit = {

    val firstString = "KATAK";
    val secondString = "TAKAK";

    println("firstString.type : " + firstString.isInstanceOf[String] + ", secondString.type : " + secondString.isInstanceOf[Int]);

    /* Check if both strings are anagram */
    if (checkIfAnagram(firstString, secondString)) {

      println("Strings '" + firstString + "' & '" + secondString + "' are Anagrams");
    } else {

      println("Strings '" + firstString + "' & '" + secondString + "' are not Anagrams");
    }
  }

  /**
   * O(2n log n) using Quick Sort
   *
   * @param firstString
   * @param secondString
   * @return
   */
  private def checkIfAnagram(firstString: String, secondString: String): Boolean = {

    /* Sort all chars in both string */
    var firstStringChars = firstString.toLowerCase.toCharArray;
    var secondStringChars = secondString.toLowerCase.toCharArray;

    /* Apply quick sort */
    scala.util.Sorting.quickSort(firstStringChars)
    scala.util.Sorting.quickSort(secondStringChars);

    /* Check if same */
    if (String.valueOf(firstStringChars).equals(String.valueOf(secondStringChars))) {

      return true;
    } else {

      return false;
    }
  }
}