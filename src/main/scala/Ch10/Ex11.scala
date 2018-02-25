package Ch10

import java.io.{FileInputStream, InputStream}

class IterableInputStream(inputStream: InputStream) extends InputStream with Iterable[Byte] {
  override def read(): Int = inputStream.read()

  override def iterator = new Iterator[Byte] {
    override def hasNext(): Boolean = inputStream.available() > 0

    override def next() = inputStream.read.toByte

  }
}

object Ex11 {
  def main(args: Array[String]): Unit = {
    val bi = new IterableInputStream(new FileInputStream("README.md")).iterator

    val r = bi.map(_.toChar).mkString

    println(r)

  }

}
