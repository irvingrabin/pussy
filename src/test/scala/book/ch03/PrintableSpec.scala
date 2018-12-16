package book.ch03

import org.scalatest.{FunSpec, Matchers}

class PrintableSpec extends FunSpec with Matchers {

  describe("handling contravariant printables") {
    val stringPrintable: Printable[String] = new Printable[String] {
      override def format( value: String ): String = s"<$value>"
    }
    val intToString = (i: Int) => s"($i)"

    it("should contramap stuff correcty") {
      stringPrintable.format("abc") shouldBe "<abc>"
      stringPrintable.contramap(intToString).format(15) shouldBe "<(15)>"
    }
  }

}
