package com.inbravo.lang

/**
 *
 */
class Mutator {

  /* '_' initialized to default value ('0') of type */
  var x: Int = _
}

/**
 * VerboseMutator is functionally equivalant to
 */
class VerboseMutator {

  /* '_' initialized to default value ('0') of type */
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
    mutator.x = 1
    println(mutator.x)

    /* Access */
    println(vMutator.x)

    /* Mutate */
    vMutator.x = 2
    println(vMutator.x)
  }
}