package com.inbravo.lang

/**
 * This object helps in understanding of Lower and Upper type bounds
 *
 * amit.dixit
 */
object TypeBoundTest extends App {

  val animal = new Animal
  val dog = new Dog
  val puppy = new Puppy

  val animalCarer = new AnimalCarer

  /* Compilation Error : 'type mismatch; found : com.inbravo.lang.Animal required: T' */
  /* animalCarer.display(animal) */
  animalCarer.upperBoundBasedMethod(dog)
  animalCarer.upperBoundBasedMethod(puppy)

  /* Method 'lowerBoundBasedMethod' can accept all supertypes of 'Puppy' class not not any subtypes of 'Puppy' class */
  animalCarer.lowerBoundBasedMethod(animal)
  animalCarer.lowerBoundBasedMethod(dog)
  animalCarer.lowerBoundBasedMethod(puppy)
}

/* Top most generalization */
class Animal

/*  Specific 'Animal' types */
class Dog extends Animal
class Puppy extends Dog
class LabradorPuppy extends Puppy

class AnimalCarer {

  /* This method accepts only either Dog class object or subclass type (i.e. Puppy) of Dog Class */
  /* Type bound expression [T <: Dog] says that 'T' can only be a subtype of 'Dog' */
  /* Upper bound is applied using operator '<:' */
  def upperBoundBasedMethod[T <: Dog](t: T) = println(t)

  /* This method accepts only either Puppy class object or superclass type (i.e. LabradorPuppy) of Puppy Class */
  /* Type bound expression [T >: Puppy] says that 'T' can only be a supertype of 'Puppy' */
  /* Lower bound is applied using operator '>:' */
  def lowerBoundBasedMethod[T >: Puppy](t: T) = println(t)
}
