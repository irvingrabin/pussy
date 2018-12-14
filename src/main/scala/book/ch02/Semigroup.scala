package book.ch02

trait Semigroup[A] {
  def combine( x: A, y: A ): A
}

object Semigroup {
  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean =
    (m.combine(m.combine(x, y), z) == m.combine(x, m.combine(y, z)))
}
