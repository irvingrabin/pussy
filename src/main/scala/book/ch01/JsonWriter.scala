package book.ch01

trait JsonWriter[A] {
  def write(value: A): Json
}
