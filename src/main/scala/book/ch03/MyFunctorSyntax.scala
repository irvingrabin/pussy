package book.ch03

object MyFunctorSyntax {
  implicit class MyFunctorOps[F[_], A]( src: F[A]) {
    def mmap[B](func: A => B)( implicit functor: MyFunctor[F]): F[B] = functor.mmap(src)(func)
  }
}
