package com.inbravo.akka.http.routes

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json._

/* Import models */
import com.inbravo.akka.http.models.{ Customer, CustomerServiceJsonSupport }

/**
 * amit.dixit
 */
class BasicRoutes extends Directives with CustomerServiceJsonSupport {

  /* Route for '/test' */
  val testRoute = path("test") { get { complete { "you are calling '/test'" } } }

  /* Route for '/customer' */
  val customerRoute = path("customer") { get { complete { Customer("InBravo") } } }
}