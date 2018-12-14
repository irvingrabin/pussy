package book.ch01

import java.util.Date

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

  it should "show custom instances 1" in {
    implicit val dateShow: Show[Date] = new Show[Date] {
      def show(date: Date): String = s"${date.getTime} since the epoch"
    }
  }

  it should "show custom instances 2" in {
    implicit val dateShow: Show[Date] = Show.show(
      date => s"${date.getTime} since the epoch")
  }

  it should "show custom instances defined correctly" in {
    Cat("Bars", 5, "black").show shouldBe "Bars is a 5 year-old black cat"
  }
}
