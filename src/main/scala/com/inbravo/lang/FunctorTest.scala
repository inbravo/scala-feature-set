package com.inbravo.lang

import scalaz.Functor

/**
 * amit.dixit
 */
/* A class */
case class Container[A](first: A, second: A)

class FunctorTest {

  implicit val demoFunctor = new Functor[Container] { def map[A, B](fa: Container[A])(f: A => B): Container[B] = Container(f(fa.first), f(fa.second)) }

  //  implicit val OptionFunctor = new Functor[Option] { def fmap[A, B](f: A => B): Option[A] => Option[B] = option => option map f }

  //implicit val ListFunctor = new Functor[List] { def fmap[A, B](f: A => B): List[A] => List[B] = list => list map f }
}




