package com.inbravo.string
/**
 *
 */
object Anagram {

  def main(args: Array[String]): Unit = {

    val firstString = "KATAK";
    val secondString = "TAKAK";

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
    var firstStringChars = firstString.toLowerCase().toCharArray();
    var secondStringChars = secondString.toLowerCase().toCharArray();

    /* Apply Dual-Pivot Quick sort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch */
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