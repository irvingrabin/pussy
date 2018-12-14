package book.ch02

import org.scalatest.{FunSpec, Matchers}
import BooleanMonoids._

class BoolSpec extends FunSpec with Matchers {

  describe("Testing boolean AND monoid") {

    describe("AND monoid") {
      val m = booleanAndMonoid
      it("should respect empty element") {
        m.combine(true, m.empty) shouldBe true
        m.combine(false, m.empty) shouldBe false
        m.combine(m.empty, true) shouldBe true
        m.combine(m.empty, false) shouldBe false
      }
    }

    describe("OR monoid") {
      val m = booleanOrMonoid
      it("should respect empty element") {
        m.combine(true, m.empty) shouldBe true
        m.combine(false, m.empty) shouldBe false
        m.combine(m.empty, true) shouldBe true
        m.combine(m.empty, false) shouldBe false
      }
    }

    describe("EITHER monoid") {
      val m = booleanEitherMonoid
      it("should respect empty element") {
        m.combine(true, m.empty) shouldBe true
        m.combine(false, m.empty) shouldBe false
        m.combine(m.empty, true) shouldBe true
        m.combine(m.empty, false) shouldBe false
      }
    }

    describe("BOTH monoid") {
      val m = booleanBothMonoid
      it("should respect empty element") {
        m.combine(true, m.empty) shouldBe true
        m.combine(false, m.empty) shouldBe false
        m.combine(m.empty, true) shouldBe true
        m.combine(m.empty, false) shouldBe false
      }
    }

  }

}
