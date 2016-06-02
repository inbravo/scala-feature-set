package com.inbravo.akka.http

import com.inbravo.akka.utils.Config
import com.inbravo.akka.http.routes.BasicRoutes
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.event.{ Logging, LoggingAdapter }

/**
 *
 */
object JsonServer extends App with Config {

  /* Create new actor system */
  implicit val actorSystem = ActorSystem("rest-api")
  implicit val actorMaterializer = ActorMaterializer()

  /* Logging */
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)

  /* Create new sample route */
  val routes = new BasicRoutes()

  /* Bind and handle */
  Http().bindAndHandle(routes.testRoute, "localhost", 8080)
}
