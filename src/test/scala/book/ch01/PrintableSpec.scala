package book.ch01

import org.scalatest.{FlatSpec, Matchers}
import Printable._

class PrintableSpec extends FlatSpec with Matchers {
  it should "format integers and strings correctly" in {
    Printable.format(1) shouldBe "<1>"
    1.format shouldBe "<1>"
  }
}
