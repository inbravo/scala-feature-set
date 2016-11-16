package com.inbravo.akka.http.models

import spray.json._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport

/* Customer case */
case class Customer(name: String)
/**
 *  amit.dixit
 */
trait CustomerServiceJsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val customerFormat = jsonFormat1(Customer)
}