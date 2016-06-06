package com.inbravo.akka.utils

import com.typesafe.config.ConfigFactory
/**
 * 	amit.dixit
 */
trait Config {

  private val config = ConfigFactory.load()
  private val server = config.getConfig("inbravo.can.server")

  val interface = server.getString("interface")
  val port = server.getInt("port")
}