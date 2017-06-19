package com.inbravo.lang

/**
 *
 */

/* An empty trait */
trait EmptyTrait

/* Trait with some property and definitions */
trait TraitWithProperty {

  /* Abstract value */
  val name: String

  override val toString = "TraitWithProperty(" + name + ")"
}

/**
 * amit.dixit
 *
 * This example demostrates how Type Inference and Ascription works in Scala
 */
object TypeAscriptionInferenceTest extends App {

  /* Instance of EmptyTrait trait can not be created without brackets '{}': marking empty implimentation */
  /* Below given two lines won't compile */
  /* val emptyTrait = new EmptyTrait */
  /* val emptyTrait = new EmptyTrait() */

  /* A valid EmptyTrait */
  val emptyTrait = new EmptyTrait {}

  /*  Will print something like 'com.inbravo.lang.PropertyObject$$anon$2@1540e19d' */
  println(emptyTrait)

  /* Without Type Ascription, the 'emptyTrait' is infered to be 'inferedTrait' */
  val inferedTrait = emptyTrait

  /* With Type Ascription */
  val anotherInferedTrait: EmptyTrait = emptyTrait

  /* 'traitWithProperty' is a subclass of 'Property' now */
  val traitWithProperty = new TraitWithProperty { override val name = "DOMAIN" }

  /* Implicit call to 'toString' will print TraitWithProperty(null). Why value of property 'name' is 'null'? */
  /* When the toString method looks for the value of name, it hasn’t been initialized yet, so it finds the value 'null' */
  println(traitWithProperty)

  /* Another implemetation to avoid initialization issue */
  /* Before the TraitWithProperty trait, there is an anonymous block containing the early member definition */
  class AnotherTraitWithProperty extends { val name = "HI" } with TraitWithProperty

  /* Now anonymous block will provide preinitialized value of name property and toString will print 'TraitWithProperty(HI)' */
  /* Early member definitions solve issues that occur when a trait defines an abstract value */
  println(new AnotherTraitWithProperty)
}