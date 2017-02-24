package com.inbravo.finagle

import com.twitter.finagle.{ Http, Service }
import com.twitter.finagle.http
import com.twitter.util.{ Await, Future }

/**
 * amit.dixit
 * 
 * A sample finagle based minimal Http service
 */
object FinagleHttpService extends App {

  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] =
      Future.value(
        http.Response(req.version, http.Status.Ok))
  }

  val server = Http.serve(":8080", service)
  Await.ready(server)
}