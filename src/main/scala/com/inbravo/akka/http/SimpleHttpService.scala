package com.inbravo.akka.http

import com.inbravo.config.ProjectConfig
import com.inbravo.akka.http.routes.BasicRoutes
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.event.{ Logging, LoggingAdapter }

/**
 * 	amit.dixit
 */
object JsonServer extends App with ProjectConfig {

  /* Create new actor system */
  implicit val actorSystem = ActorSystem("rest-api")
  implicit val actorMaterializer = ActorMaterializer()

  /* Logging */
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)

  /* Create new sample route */
  val routes = new BasicRoutes()

  println(interface)
  println(port)

  /* Bind and handle */
  Http().bindAndHandle(routes.testRoute, "localhost", 8080)
}
