package Ch10

import java.io.{BufferedInputStream, FileInputStream}

trait BufferedInputStreamingTrait extends FileInputStream {
  val buffer = new BufferedInputStream(this)

  override def read(b: Array[Byte]): Int = buffer.read(b)
}

object Ex9 {
  def main(args: Array[String]): Unit = {
    val b = new FileInputStream("build.sbt") with BufferedInputStreamingTrait
    val buffer = new Array[Byte](100)
    val offset = b.read(buffer)
    buffer.take(offset).foreach(byte => print(byte.toChar))
  }
}