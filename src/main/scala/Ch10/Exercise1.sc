import java.awt.Point
import java.awt.geom.Ellipse2D

//1
trait RectangleLike {
  def translate(a: Int, b: Int) = a + b

  def grow(a: Int, b: Int) = a * b

}

val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
egg.translate(5, 10)
egg.grow(10, 20)

//2

class OrderPoint extends java.awt.Point with scala.math.Ordered[Point] {
  override def compare(that: Point) = {
    if (this.x > that.x) 1
    else if (this.x == that.x && this.y > that.y) 1
    else if (this.x == that.x && this.y == that.y) 0
    else -1
  }
}

val key: Int = 3
for (ch <- "abcZ") yield {
  if (ch.isLetter) ch.isLower match {
    case true => {
      if ((ch + key).toChar > 'z')
        (ch - (26 - key)).toChar
      else (ch + key).toChar
    }
    case false => {
      if ((ch + key).toChar > 'Z')
        (ch - (26 - key)).toChar
      else (ch + key).toChar
    }
  }
  else ch
}

//4
trait CryptoLogger {
  val shift = 3

  def encrypt(log: String):String = {
    for (ch <- log) yield {
      if (ch.isLetter) ch.isLower match {
        case true => {
          if ((ch + shift).toChar > 'z')
            (ch - (26 - shift)).toChar
          else (ch + shift).toChar
        }
        case false => {
          if ((ch + shift).toChar > 'Z')
            (ch - (26 - shift)).toChar
          else (ch + shift).toChar
        }
      }
      else ch
    }
  }
}

class Log(val message:String) extends CryptoLogger

val log = new Log("testzMessage")
log.encrypt(log.message)

class Log2(val message:String) extends CryptoLogger{
  override val shift=5
}

val log2 = new Log2("testzMessage")
log2.encrypt(log2.message)


