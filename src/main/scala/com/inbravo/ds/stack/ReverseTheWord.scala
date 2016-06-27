package com.inbravo.ds.stack

final object ReverseTheWord {

  def main(args: Array[String]): Unit = println(reverse("AMITDIXIT"))

  /* Push elements in stack */
  def reverse(inputString: String): String = {

    /* Using stack */
    implicit var stack = new Stack(10)

    /* Push the char in stack */
    for (i <- 0 to inputString.length() - 1) {

      /* Get each char */
      var ch = inputString.charAt(i)

      /* Push on stack */
      stack.push(ch)
    }

    /* Reverse of input string */
    var reverse = ""

    for (i <- 0 to inputString.length() - 1) {

      /* Pop from stack */
      var poppedValue = stack.pop().toChar

      /* Add this char in string */
      reverse = reverse.concat("" + poppedValue)
    }

    return reverse
  }
}