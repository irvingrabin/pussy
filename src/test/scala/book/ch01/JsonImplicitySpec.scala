package book.ch01

import org.scalatest.{FlatSpec, Matchers}

import JsonWriterInstances._

class JsonImplicitySpec extends FlatSpec with Matchers {
  it should "show implicitly" in {
    val sw = implicitly[JsonWriter[String]]
    sw.write("abc") shouldBe JsonString("abc")
    val dw = implicitly[JsonWriter[Double]]
    dw.write(14.5) shouldBe JsonDouble(14.5)
    val pw = implicitly[JsonWriter[Person]]
    pw.write(Person("Irving Rabin", "ii6rr5@gmail.com")) shouldBe JsonObject(Map(
      "name"  -> JsonString("Irving Rabin"),
      "email" -> JsonString("ii6rr5@gmail.com")
    ))
  }
}
