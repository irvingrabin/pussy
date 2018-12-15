package book.ch02

import org.scalatest.{FunSpec, Matchers}

import cats.Monoid
import cats.instances.int._
import cats.instances.double._
import cats.syntax.semigroup._

class SuperAdderSpec extends FunSpec with Matchers {

  describe("having a superadder") {
    def intAddMonoid: Monoid[Int] = new Monoid[Int] {
      override def combine( x: Int, y: Int ): Int = x + y
      override def empty: Int = 0
    }

    def add[A](items: List[A])(implicit m: Monoid[A]): A = items.foldLeft(m.empty)(_ |+| _)

    case class Order( unitCost: Double, quantity: Double)
    case class TotalOrder(totalCost: Double, quantity: Double)

    implicit val totalOrderMonoid: Monoid[TotalOrder] = new Monoid[TotalOrder] {
      override def empty = TotalOrder(0.0, 0.0)
      override def combine( x: TotalOrder, y: TotalOrder ): TotalOrder = TotalOrder(
        x.totalCost + y.totalCost, x.quantity + y.quantity
      )
    }

    it("should add lists correctly") {
      add(List(1, 3, 5, 7, 9)) shouldBe 25
      add(List[Int]()) shouldBe 0
      add(List(15)) shouldBe 15
    }

    it("should add orders correctly") {
      val orders = List(Order(2.25, 14.0), Order(3.00, 8.50))
      add(orders.map(x => x.unitCost * x.quantity)) shouldBe 57.0
    }

    it("should add total orders correctly") {
      val orders = List(TotalOrder(31.5, 14.0), TotalOrder(25.5, 8.50))
      add(orders)shouldBe TotalOrder(57.0, 22.5)
    }
  }

}
