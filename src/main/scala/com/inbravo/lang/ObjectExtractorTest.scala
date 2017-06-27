package com.inbravo.lang

/**
 * How 'unapply' method helps in removing sugar coats as per your needs
 *
 * amit.dixit
 */
object ObjectExtractorTest extends App {

  /* Different types of ip addresses */
  val ip = "127.0.0.1"
  val nonIP = "128.-112.ABC."

  /* Pattern matching calls 'IPAddress.unapply(ip)' */
  ip match {
    case IPAddress(_, _, _, a) => println(a)
    case _                     => println("Invalid ip address")
  }

  /* Pattern matching calls 'IPAddress.unapply(nonIP)' */
  nonIP match {
    case IPAddress(_, _, _, a) => println(a)
    case _                     => println("Invalid ip address")
  }
}

/* IPAddress object */
object IPAddress {

  /* The 'apply' method takes some arguments and yields an element of a given set. This method is called an injection */
  def apply(a: String, b: String, c: String, d: String): String = a + "." + b + "." + c + "." + d

  /* The 'unapply' method helps in removing any sugar coating */
  /* The 'unapply' method is called extractor because it takes an element of the same set and extracts some of its parts */
  def unapply(ip: String): Option[(String, String, String, String)] = {

    val tokens = ip split "\\."
    if (tokens.length == 4 && isValid(tokens)) Some(tokens(0), tokens(1), tokens(2), tokens(3)) else None
  }

  private def isValid(tokens: Array[String]): Boolean = {

    tokens forall {

      /* Apply logic for all elements of array */
      elem =>

        try {
          val intValue = elem.toInt

          intValue >= 0 && intValue <= 255
        } catch {

          /* return false for any error */
          case _ => false
        }
    }
  }
}