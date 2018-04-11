package Ch12

object ControlAbstraction {
  def until(condition: => Boolean)(block: => Unit): Unit = {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until(i == str.length) {
      if (str(i) == ch) return i
      i += 1
    }
    return -1
  }

  def main(args: Array[String]): Unit = {
    var x = 10
    until(x == 0) {
      x -= 1
      println(x)
    }

    println(indexOf("This", 'i'))
  }

}
