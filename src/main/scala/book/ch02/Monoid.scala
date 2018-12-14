package book.ch02

trait Monoid[A] extends Semigroup[A]{
  def empty: A
}

object Monoid {
  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean =
    (m.combine(m.empty, x) == x && m.combine(x, m.empty) == x)
}
