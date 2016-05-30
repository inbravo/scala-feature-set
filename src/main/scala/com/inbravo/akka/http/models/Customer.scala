package com.inbravo.akka.http.models

import spray.json.DefaultJsonProtocol

/* Customer case */
case class Customer(name: String)

/* Create JSON protocol for customer using spray.io */
object CustomerServiceJsonProtocol extends DefaultJsonProtocol {

  implicit val customerProtocol = jsonFormat1(Customer)
}