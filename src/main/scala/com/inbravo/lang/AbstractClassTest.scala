package com.inbravo.lang

/**
 * How keywords 'final' and 'abstract' can stay together in Scala
 * amit.dixit
 */
final abstract class AbstractClass {

  def someMethod()

  def someOtherMethod() {
    println("talking from someOtherMethod")
  }
}

object AbstractClassTest {

  /* Class AbstractClass is abstract; cannot be instantiated */
  /* var abstractClass = new AbstractClass */
}

/* Illegal inheritance from final class AbstractClass*/
/* class FinalClass extends AbstractClass */