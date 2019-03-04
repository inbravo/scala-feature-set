package com.inbravo.net

import java.net._
import java.io._
import scala.io._

object SocketTest {

  def main(args: Array[String]): Unit = {

    val s = new Socket(InetAddress.getByName("192.168.218.154"), 9000)
    lazy val in = new BufferedSource(s.getInputStream()).getLines()
    val out = new PrintStream(s.getOutputStream())

    out.println("Hello, world")
    out.flush()
    println("Received: " + in.next())

    s.close()
  }
}
