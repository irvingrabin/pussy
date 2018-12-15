package book.ch02

import cats.Semigroup

object SetSemigroups {
  implicit def setJoinSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    override def combine( x: Set[A], y: Set[A] ): Set[A] = x union y
  }
  implicit def setIntersectSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    override def combine( x: Set[A], y: Set[A] ): Set[A] = x intersect y
  }
  implicit def setSymDiffSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    override def combine( x: Set[A], y: Set[A] ): Set[A] = (x diff y) union (y diff x)
  }
}
