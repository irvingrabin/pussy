package book.ch01

import org.scalatest.{FlatSpec, Matchers}

class JsonInterfaceObjectsSpec extends FlatSpec with Matchers {
  it should "produce Json from interface objects" in {
    Json.toJson("abc") shouldBe JsonString("abc")
    Json.toJson(14.5) shouldBe JsonDouble(14.5)
    Json.toJson(145) shouldBe JsonInt(145)
    Json.toJson(Person("Irving Rabin", "ii6rr5@gmail.com")) shouldBe JsonObject(Map(
      "name"  -> JsonString("Irving Rabin"),
      "email" -> JsonString("ii6rr5@gmail.com")
    ))
    Json.toJson[Option[String]](None) shouldBe JsonNull
    Json.toJson[Option[String]](Some("abc")) shouldBe JsonString("abc")
  }
}
