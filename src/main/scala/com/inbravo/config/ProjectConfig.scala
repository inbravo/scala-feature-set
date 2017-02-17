package com.inbravo.config

import com.typesafe.config.ConfigFactory
/**
 * 	amit.dixit
 */
trait ProjectConfig {

  private val config = ConfigFactory.load()
  private val server = config.getConfig("inbravo.can.server")

  val interface = server.getString("interface")
  val port = server.getInt("port")
}