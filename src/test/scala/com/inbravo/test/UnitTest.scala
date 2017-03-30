package com.inbravo.test

import org.scalatest.{ FlatSpec, Matchers }

/**
 * Base class of all unit test
 * amit.dixit
 */
abstract class UnitTest(component: String) extends FlatSpec
    with Matchers {
  behavior of component
}