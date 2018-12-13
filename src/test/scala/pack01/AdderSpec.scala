package pack01

import org.scalatest.{FlatSpec, Matchers}
import pack01.Adder._

class AdderSpec extends FlatSpec with Matchers {

  it should "run of adder" in {
    add(4, 6) shouldBe 10
  }

}
