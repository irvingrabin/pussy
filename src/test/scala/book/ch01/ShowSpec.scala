package book.ch01

import org.scalatest.{FlatSpec, Matchers}
import cats.Show
import cats.instances.int._
import cats.instances.string._

import cats.syntax.show._

class ShowSpec extends FlatSpec with Matchers {

  it should "show cats with instances" in {
    val showInt = Show.apply[Int]
    val showString = Show.apply[String]

    showInt.show(123) shouldBe "123"
    showString.show("abc") shouldBe "abc"
  }

  it should "show cats with syntax" in {
    123.show shouldBe "123"
    "abc".show shouldBe "abc"
  }
}
