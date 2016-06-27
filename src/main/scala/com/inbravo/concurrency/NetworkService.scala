package com.inbravo.concurrency

import java.net.{ Socket, ServerSocket }
import java.util.concurrent.{ Executors, ExecutorService }
import java.util.Date

/*
 * Point your browser to '127.0.0.1:2020'
 */
final class NetworkService(port: Int, poolSize: Int) extends Runnable {

  /* Create new server socket */
  val serverSocket = new ServerSocket(port)

  /* Create new pool based executor service */
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)

  def run() {

    /* Run infinite */
    while (true) {

      /* This will block until a connection comes in */
      val socket = serverSocket.accept()

      /* Let the pool handle client requests */
      pool.execute(new Handler(socket))
    }
  }
}

/**
 * Handler class to serve all client requests
 */
final class Handler(socket: Socket) extends Runnable {

  def message = ("a handler(thread:" + Thread.currentThread().getId + ") is listening...." + "\n").getBytes

  def run() {
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}

object NetWorkServiceTest {

  def main(args: Array[String]): Unit = (new NetworkService(2020, 2)).run
}
