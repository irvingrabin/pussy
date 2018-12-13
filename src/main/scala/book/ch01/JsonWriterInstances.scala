package book.ch01

object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] = new JsonWriter[String] {
    override def write( value: String ): Json = JsonString(value)
  }
  implicit val doubleWriter: JsonWriter[Double] = new JsonWriter[Double] {
    override def write( value: Double ): Json = JsonDouble(value)
  }
  implicit val personWriter: JsonWriter[Person] = new JsonWriter[Person] {
    override def write( value: Person ): Json = JsonObject(Map(
      "name"  -> JsonString(value.name),
      "email" -> JsonString(value.email)
    ))
  }
}
