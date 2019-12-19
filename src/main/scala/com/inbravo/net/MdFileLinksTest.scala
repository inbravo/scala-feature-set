package com.inbravo.net

import java.net._
import java.io._
import scala.io._
import java.util.regex.Pattern
import java.util.regex.Matcher

/**
 * Verify all HTTP URLs of a markdown file
 * amit.dixit
 */
object MdFileLinksTest {

  def main(args: Array[String]): Unit = {

    validateLinksOfFile("D://personal//mygithub//java-src//readme.md")
  }

  /**
   * Read file content
   */
  def validateLinksOfFile(f: String): Unit = {

    /* Pattern for recognizing a URL, based off RFC 3986 */
    val urlPattern: Pattern = Pattern.compile(
      "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
        + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
        + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
      Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    /* Create source */
    val source = Source.fromFile(f)
    var httpURL: String = ""

    try {

      /* Get file */
      for (line <- source.getLines) {

        /* Get the HTTP URL from the line */
        val matcher: Matcher = urlPattern.matcher(line);

        while (matcher.find) {

          /* Extract the exact HTTP URL from line */
          var httpURL: String = line.substring(matcher.start(1), matcher.end)

          /* Call this my local GITHUB Repo URLs */
          if (httpURL.contains("github.com/inbravo")) {

            /* If the URL is not found */
            if (getHTTPReturnCode(httpURL).equals(404)) {
              println("Failed URL: " + httpURL)
            }
          }
        }
      }
    } finally source.close
  }

  /**
   * Get HTTP return code for the URL
   */
  def getHTTPReturnCode(httpURL: String): Int = {

    /* New URL object */
    val u: URL = new URL(httpURL)

    /* Create URL connection */
    val huc: HttpURLConnection = u.openConnection.asInstanceOf[HttpURLConnection]

    /* Set HTTP method details */
    huc.setRequestMethod("GET")

    /* Initiate HTTP connection */
    try huc.connect

    catch {

      /* Check for all exception cases */
      case e: IOException => e.getMessage
    }

    /* Return HTTP response code */
    return huc.getResponseCode
  }
}