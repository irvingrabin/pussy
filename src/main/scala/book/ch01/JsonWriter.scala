package book.ch01

trait  JsonWriter[A] {
  def write(value: A): Json
}

object JsonWriter {
  // Writer instances
  implicit val stringWriter: JsonWriter[String] = new JsonWriter[String] {
    override def write( value: String ): Json = JsonString(value)
  }
  implicit val intWriter: JsonWriter[Int] = new JsonWriter[Int] {
    override def write( value: Int ): Json = JsonInt(value)
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
  implicit def optionWriter[A
  ]( implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
    new JsonWriter[Option[A]] {
      def write(oa: Option[A]): Json = oa match {
        case Some(a) => writer.write(a)
        case None    => JsonNull
      }
    }
  // Syntax
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json =  w.write(value)
  }
}
