package Ch10

import java.io.{BufferedInputStream, FileInputStream}

trait Logger {
  def log(msg: String)
}


trait TraitConsoleLogger {
  def log(msg: String): Unit = println(msg)
}

trait BufferedInputStreamingTrait2 extends FileInputStream with TraitConsoleLogger {
  val buffer = new BufferedInputStream(this)

  override def read(b: Array[Byte]):Int ={
    log("Now is buffering read...")
    buffer.read(b)

  }
}


object Ex10 {
  def main(args: Array[String]): Unit = {
    val b = new FileInputStream("build.sbt") with BufferedInputStreamingTrait2
    val buffer = new Array[Byte](100)
    val offset = b.read(buffer)
    buffer.take(offset).foreach(byte => print(byte.toChar))
  }
}