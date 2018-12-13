package book.ch01

trait Printable[A] {
  def format(value: A): String
}

object Printable {
  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    def format(i: Int): String = stringPrintable.format(i.toString)
  }
  implicit val stringPrintable: Printable[String] = new Printable[String] {
    def format(s: String): String = s"<$s>"
  }
  def format[A](value: A)(implicit pf: Printable[A]): String = pf.format(value)
  def print[A](value: A)(implicit pf: Printable[A]): Unit = { println(pf.format(value)) }

  implicit class PrintableSyntax[A](value: A) {
    def format(implicit pf: Printable[A]): String = Printable.format(value)
    def print(implicit pf: Printable[A]): Unit = Printable.print(value)
  }
}
