package com.inbravo.ds.queue

import com.inbravo.test.UnitTest

/**
 *
 * amit.dixit
 */
class CircularQueueTest extends UnitTest("CircularQueue") {

  /* A test value */
  val insertedValue = 10

  /* Create new queue */
  var queue = new com.inbravo.ds.queue.CircularQueue

  /* Positive: Check for empty */
  "An empty Queue" should "not be full" in (queue.isEmpty shouldBe true)

  /* Positive: Check for full */
  "An empty Queue" should "be empty" in (queue.isFull shouldBe false)

  /* Positive: Check for peek front */
  "An empty Queue" should "have nothing at front" in (queue.peekFront shouldEqual 0)

  /* Push item in queue */
  queue.insert(insertedValue)

  /* Positive: Check for peek front */
  "Newly inserted value" should "be at front of Queue" in (insertedValue shouldBe queue.peekFront)

  /* Negative: Check for peek front */
  "A filled Queue" should "not have value(0) at front" in (queue.peekFront should not be 0)

  /* Remove item from queue */
  val removedValue = queue.remove

  /* Positive: Check for remove */
  "A filled Queue" should "yeild value(" + insertedValue + ") while removal" in (removedValue shouldBe insertedValue)

  /* Positive: Check for full */
  "Post removal of all elements, a Queue" should "not be full" in (queue.isEmpty shouldBe true)

  /* Positive: Check for empty */
  "Post removal of all elements, a Queue" should "be empty" in (queue.isFull shouldBe false)
}