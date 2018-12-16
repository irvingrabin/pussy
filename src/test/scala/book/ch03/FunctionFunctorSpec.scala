package book.ch03

import org.scalatest.{FlatSpec, Matchers}
import cats.syntax.functor._
import cats.instances.function._

class FunctionFunctorSpec extends FlatSpec with Matchers {
  it should "test inline Function functor" in {
    val func1: Int => Double = _.toDouble
    val func2: Double => Double = _ * 3
    (func1 map func2)(5) shouldBe 15.0
  }
  it should "test inClass Function functor" in {
    (FunctionFunctor.func1 map FunctionFunctor.func2)(7) shouldBe 14.0
  }
}
