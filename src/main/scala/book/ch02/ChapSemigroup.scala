package book.ch02

trait ChapSemigroup[A] {
  def combine( x: A, y: A ): A
}

object ChapSemigroup {
  def associativeLaw[A](x: A, y: A, z: A)(implicit m: ChapMonoid[A]): Boolean =
    (m.combine(m.combine(x, y), z) == m.combine(x, m.combine(y, z)))
}
