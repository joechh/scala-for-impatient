import java.awt.Rectangle

//7.
class Square(x: Int, y: Int, width: Int) extends Rectangle(x, y, width, width) {
  def this(width: Int) = {
    this(0, 0, width)
  }

  def this() = {
    this(0, 0, 0)
  }

}

val s1 = new Square(1, 2, 3)
val s2 = new Square(4)
val s3 = new Square()

class Point(private val pack:Long) extends AnyVal{
  def x:Int={
    val length=pack.toString.length
    Integer.parseInt(pack.toString.take(length/2))
  }
  def y:Int={
    val length=pack.toString.length
    Integer.parseInt(pack.toString.takeRight(length/2))
  }

}

val p = new Point(1234)
p.x
p.y

