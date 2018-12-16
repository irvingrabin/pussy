package book.ch03

import org.scalatest.{FunSpec, Matchers}
import MyFunctorSyntax._

class MyFunctorSpec extends FunSpec with Matchers {

  describe("testing functor laws") {

    val listSource: List[Int] = List(1, 2, 3, 4, 5)
    val listEmpty: List[Int] = List()
    val treeSource: Tree[Int] = Branch(
      Branch(
        Leaf(5),
        Branch(Leaf(3), Leaf(7))
      ),
      Branch(
        Branch(
          Branch(
            Leaf(50),
            Branch(
              Leaf(45), Leaf(55)
            )
          ),
          Leaf(77)
        ),
        Leaf(99)
      )
    )
    val optSource: Option[Int] = Some(25)
    val optNone: Option[Int] = None
    val id = (x: Int) => x
    val p4 = (x: Int) => x + 4
    val m3 = (x: Int) => x * 3

    it("should follow identity law") {
      listSource.mmap(id) shouldBe listSource
      listEmpty.mmap(id) shouldBe listEmpty
      optSource.mmap(id) shouldBe optSource
      optNone.mmap(id) shouldBe optNone
      treeSource.mmap(id) shouldBe treeSource
    }

    it("should follow composition law") {
      listSource.mmap(p4).mmap(m3) shouldBe List(15, 18, 21, 24, 27)
      listSource.mmap(m3).mmap(p4) shouldBe List(7, 10, 13, 16, 19)
      listEmpty.mmap(p4).mmap(m3) shouldBe List()
      listEmpty.mmap(m3).mmap(p4) shouldBe List()
      optSource.mmap(p4).mmap(m3) shouldBe Some(87)
      optSource.mmap(m3).mmap(p4) shouldBe Some(79)
      optNone.mmap(p4).mmap(m3) shouldBe None
      optNone.mmap(m3).mmap(p4) shouldBe None
    }

    it("should follow composition law for trees") {
      treeSource.mmap(p4).mmap(m3) shouldBe Branch(
        Branch(
          Leaf(27),
          Branch(Leaf(21), Leaf(33))
        ),
        Branch(
          Branch(
            Branch(
              Leaf(162),
              Branch(
                Leaf(147), Leaf(177)
              )
            ),
            Leaf(243)
          ),
          Leaf(309)
        )
      )
      treeSource.mmap(m3).mmap(p4) shouldBe Branch(
        Branch(
          Leaf(19),
          Branch(Leaf(13), Leaf(25))
        ),
        Branch(
          Branch(
            Branch(
              Leaf(154),
              Branch(
                Leaf(139), Leaf(169)
              )
            ),
            Leaf(235)
          ),
          Leaf(301)
        )
      )
    }

  }
}

