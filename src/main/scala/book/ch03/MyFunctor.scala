package book.ch03
import scala.language.higherKinds

trait MyFunctor[F[_]] {
  def mmap[A, B](fa: F[A])(f: A => B): F[B]
}

object MyFunctor {
  implicit val myListFunctor: MyFunctor[List] = new MyFunctor[List] {
    def mmap[A, B]( fa: List[A] )( f: A => B ): List[B] = fa match {
      case x :: xs => f(x) :: mmap(xs)(f)
      case Nil     => Nil
    }
  }
  implicit val myOptionFunctor: MyFunctor[Option] = new MyFunctor[Option] {
    override def mmap[A, B]( fa: Option[A] )( f: A => B ): Option[B] = fa match {
      case Some(x) => Some(f(x))
      case None    => None
    }
  }
  implicit val myTreeFunctor: MyFunctor[Tree] = new MyFunctor[Tree] {
    override def mmap[A, B]( fa: Tree[A] )( f: A => B ): Tree[B] = fa match {
      case Branch(left, right) => Branch(mmap(left)(f), mmap(right)(f))
      case Leaf(leaf)          => Leaf(f(leaf))
    }
  }
}
