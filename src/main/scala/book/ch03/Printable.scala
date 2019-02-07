package book.ch03

trait Printable[A] { self =>
  def format( value: A ): String
  def contramap[B]( f: B => A ): Printable[B] = v => self.format(f(v))
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)

  implicit val stringPrintable: Printable[String] = v => v
  implicit val booleanPrintable: Printable[Boolean] = v => if (v) "true" else "false"
  implicit val integerPrintable: Printable[Int] = v => v.toString
}
