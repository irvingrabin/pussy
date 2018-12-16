package book.ch03

import org.scalatest.{FunSpec, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._

class RandomFutureSpec extends FunSpec with Matchers {
  describe("Non-functionality of Future/Randoms") {
    it("should show same values for future1") {
      val result1 = Await.result(RandomFuture.future1, 1.second)
      result1._1 shouldBe result1._2
    }

    it("should show different values for future2") {
      val result2 = Await.result(RandomFuture.future2, 1.second)
      result2._1 should not be result2._2
    }
  }
}
