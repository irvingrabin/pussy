package book.ch02

import org.scalatest.{FunSpec, Matchers}
import SetSemigroups._

class SetSpec extends FunSpec with Matchers {

  describe("Set Semigroups") {
    val s1 = Set(1, 3, 5, 7, 9)
    val s2 = Set(2, 3, 4, 5, 6)
    val s3 = Set(1, 5, 9, 13, 17)

    it(" checks Join Semigroup") {
      val sm = setJoinSemigroup[Int]
      sm.combine(s1, sm.combine(s2, s3)) shouldBe sm.combine(sm.combine(s1, s2), s3)
    }

    it("checks Intersect Semigroup") {
      val sm = setIntersectSemigroup[Int]
      sm.combine(s1, sm.combine(s2, s3)) shouldBe sm.combine(sm.combine(s1, s2), s3)
    }

    it("checks SymDiff Semigroup") {
      val sm = setSymDiffSemigroup[Int]
      sm.combine(s1, sm.combine(s2, s3)) shouldBe sm.combine(sm.combine(s1, s2), s3)
    }
  }

  describe("Set Monoids") {

  }
}
