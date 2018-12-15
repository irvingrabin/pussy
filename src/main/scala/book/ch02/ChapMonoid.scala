package book.ch02

trait ChapMonoid[A] extends ChapSemigroup[A]{
  def empty: A
}

object ChapMonoid {
  def identityLaw[A](x: A)(implicit m: ChapMonoid[A]): Boolean =
    (m.combine(m.empty, x) == x && m.combine(x, m.empty) == x)
}
