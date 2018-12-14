package book.ch01

import org.scalactic.{TripleEquals => _, TripleEqualsSupport => _}
import org.scalatest.{FunSpec, Matchers}
import cats.syntax.eq._

class EqSpec extends FunSpec with Matchers {

  describe("Cats Eq") {

    it("should correctly tell when two cats are equal or not equal") {
      val cat1 = Cat("Garfield", 8, "orange and black")
      val cat2 = Cat("GARFIELD", 8, "Orange And Black")
      val cat3 = Cat("Leopold", 15, "gray")
      cat1 =!= cat1 shouldBe false
      cat1 =!= cat2 shouldBe false
      cat1 =!= cat3 shouldBe true
      cat2 =!= cat1 shouldBe false
      cat2 =!= cat2 shouldBe false
      cat2 =!= cat3 shouldBe true
      cat3 =!= cat1 shouldBe true
      cat3 =!= cat2 shouldBe true
      cat3 =!= cat3 shouldBe false
    }

  }
}
