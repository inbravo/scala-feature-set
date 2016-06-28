package com.inbravo.akka.basic

import akka.actor._

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

/**
 *
 */
class Ping(pong: ActorRef) extends Actor {

  var count = 0
  def incrementAndPrint { count += 1; println("ping") }

  def receive = {

    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage

    case PongMessage =>

      incrementAndPrint

      if (count > 99) {

        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {

        sender ! PingMessage
      }
  }
}

class Pong extends Actor {

  def receive = {

    case PingMessage =>
      println("  pong")
      sender ! PongMessage

    case StopMessage =>
      println("pong stopped")
      context.stop(self)
  }
}

object PingPongTest extends App {

  /* Create new actor system */
  val system = ActorSystem("PingPongSystem")

  /* Create a pong actor */
  val pong = system.actorOf(Props[Pong], name = "pong")

  /* Create a ping actor */
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")

  /* Start using '|' operator of akka */
  ping ! StartMessage
}