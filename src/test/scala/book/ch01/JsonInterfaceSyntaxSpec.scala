package book.ch01

import org.scalatest.{FlatSpec, Matchers}
import JsonWriterInstances._
import JsonSyntax._

class JsonInterfaceSyntaxSpec extends FlatSpec with Matchers {
  it should "produce Json from interface objects" in {
    "abc".toJson shouldBe  JsonString("abc")
    14.5.toJson shouldBe JsonDouble(14.5)
    Person("Irving Rabin", "ii6rr5@gmail.com").toJson shouldBe JsonObject(Map(
      "name"  -> JsonString("Irving Rabin"),
      "email" -> JsonString("ii6rr5@gmail.com")
    ))
  }
}
