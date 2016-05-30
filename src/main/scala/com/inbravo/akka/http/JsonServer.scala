package com.inbravo.akka.http

import java.util.concurrent.ConcurrentLinkedDeque

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.event.{ Logging, LoggingAdapter }
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import spray.json.DefaultJsonProtocol
import spray.json.DefaultJsonProtocol._
import scala.collection.JavaConverters._

/* Import models*/
import com.inbravo.akka.http.models.{ Customer, CustomerServiceJsonProtocol }

/* Import application configuration */
import com.inbravo.akka.utils.Config;
/**
 *
 */
object JsonServer extends App with Config {

  implicit val actorSystem = ActorSystem("rest-api")
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)

  implicit val actorMaterializer = ActorMaterializer()

  /* Create dequeue on customer */
  val list = new ConcurrentLinkedDeque[Customer]()

  /* Import customer protocol */
  import CustomerServiceJsonProtocol.customerProtocol

  val route =
    path("customer") {
      post {
        entity(as[Customer]) {
          customer =>
            complete {
              list.add(customer)
              s"got customer with name ${customer.name}"
            }
        }
      } ~
        get {
          complete {
            list.asScala
          }
        }
    }

  Http().bindAndHandle(route, "localhost", 8080)
}
