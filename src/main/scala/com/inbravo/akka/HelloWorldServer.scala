package com.inbravo.akka

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

/**
 *
 */
object HelloWorldServer {

  def main(args: Array[String]) {

    implicit val actorSystem = ActorSystem("system")
    implicit val actorMaterializer = ActorMaterializer()

    val route =
      pathSingleSlash {
        get {
          complete {
            "Hello world from HelloWorldServer"
          }
        }
      }

    Http().bindAndHandle(route, "localhost", 8080)

    println("server started at 8080")
  }
}