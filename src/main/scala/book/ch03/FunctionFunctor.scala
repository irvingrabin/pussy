package book.ch03
import cats.syntax.functor._
import cats.instances.function._

object FunctionFunctor {
  val func1: Int => Double = (x: Int) => x.toDouble
  val func2: Double => Double = (y: Double) => y * 2
}
