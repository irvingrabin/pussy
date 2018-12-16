package book.ch03

trait Printable[A] { self =>
  def format( value: A ): String
  def contramap[B]( f: B => A ): Printable[B] = v => self.format(f(v))
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
}
