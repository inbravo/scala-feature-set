package com.inbravo.lang

/**
 *
 */
class Mutator {

  var x: Int = _
}

class VerboseMutator {

  private[this] var internal: Int = _

  /* Accessor */
  def x: Int = internal

  /* Mutator */
  def x_=(x: Int): Unit = internal = x
}

object MutatorTest {

  def main(args: Array[String]) {

    val mutator = new Mutator
    val vMutator = new VerboseMutator

    /* Access */
    println(mutator.x)

    /* Mutate */
    println(mutator.x = 1)

    /* Access */
    println(vMutator.x)

    /* Mutate */
    println(vMutator.x = 1)
  }
}