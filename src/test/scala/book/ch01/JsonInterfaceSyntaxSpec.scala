package book.ch01

import org.scalatest.{FlatSpec, Matchers}
import JsonWriter._

class JsonInterfaceSyntaxSpec extends FlatSpec with Matchers {
  it should "produce Json from interface objects" in {
    "abc".toJson shouldBe  JsonString("abc")
    14.5.toJson shouldBe JsonDouble(14.5)
    145.toJson shouldBe JsonInt(145)
    Person("Irving Rabin", "ii6rr5@gmail.com").toJson shouldBe JsonObject(Map(
      "name"  -> JsonString("Irving Rabin"),
      "email" -> JsonString("ii6rr5@gmail.com")
    ))
    (None: Option[String]).toJson shouldBe JsonNull
    (Some("abc"): Option[String]).toJson shouldBe JsonString("abc")
    Option("abc").toJson shouldBe JsonString("abc")
  }
}
