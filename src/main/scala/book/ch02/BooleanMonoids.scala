package book.ch02

object BooleanMonoids {
  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(a: Boolean, b: Boolean): Boolean = a && b
    def empty: Boolean = true
  }
  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(a: Boolean, b: Boolean): Boolean = a || b
    def empty: Boolean = false
  }
  implicit val booleanEitherMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(a: Boolean, b: Boolean): Boolean = !(a == b)
    def empty: Boolean = false
  }
  implicit val booleanBothMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def combine(a: Boolean, b: Boolean): Boolean = (a == b)
    def empty: Boolean = true
  }
}
