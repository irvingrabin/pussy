package book.ch01

import cats.{Eq, Show}
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import cats.syntax.eq._

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val catShow: Show[Cat] = Show.show[Cat] { cat =>
    s"${cat.name.show} is a ${cat.age.show} year-old ${cat.color.show} cat"
  }
  implicit val catEqual: Eq[Cat] = Eq.instance[Cat] {
    (cat1, cat2) => {
      (cat1.name.toLowerCase === cat2.name.toLowerCase) &&
        (cat1.age === cat2.age) &&
        (cat1.color.toLowerCase === cat2.color.toLowerCase)
    }
  }
  implicit val catOptionEqual: Eq[Option[Cat]] = Eq.instance[Option[Cat]] { (cat1, cat2) =>
    (cat1, cat2) match {
      case (None, None)                      => true
      case (Some(_), None) | (None, Some(_)) => false
      case (Some(a), Some(b))                => a === b
    }
  }
}
