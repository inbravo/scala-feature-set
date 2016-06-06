package com.inbravo.akka.http

import com.inbravo.akka.utils.Config
import com.inbravo.akka.http.routes.BasicRoutes
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.event.{ Logging, LoggingAdapter }
import spray.json._

/**
 * amit.dixit
 */
object CustomerRestService extends App with Config {

  /* Create new actor system */
  implicit val actorSystem = ActorSystem("rest-api")
  implicit val actorMaterializer = ActorMaterializer()

  /* Logging */
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)

  /* Create new sample route */
  val routes = new BasicRoutes()

  /* Strip margin is used adding new lines in string */
  val banner = s"""| This Service is capable to,
                 | create/read/update/delete 
                 | customers """.stripMargin

  /* Print the banner */
  println(banner)

  /* Bind and handle */
  Http().bindAndHandle(routes.customerRoute, "localhost", 8080)
}