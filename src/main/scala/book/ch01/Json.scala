package book.ch01

sealed trait Json {
}
final case class JsonObject(get: Map[String, Json]) extends Json
final case class JsonString(get: String) extends Json
final case class JsonDouble(get: Double) extends Json
case object JsonNull extends Json

object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
}
