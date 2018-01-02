import java.awt.Point

//1.
object Conversions {
  def inchesToCentimeters(inches: Int) = inches * 2.54

  def gallonsToLiters(gallons: Int) = gallons * 3.79

  def milesToKilometers(miles: Int) = miles * 1.609
}

//2. more OO
abstract class UnitConversion {
  def convert(value: Double): Double

}

object InchesToCentimeters extends UnitConversion {
  override def convert(inches: Double) = inches * 2.54
}

object GallonsToLiters extends UnitConversion {
  override def convert(gallons: Double) = gallons * 3.79
}

object MilesToKilometers extends UnitConversion {
  override def convert(miles: Double) = miles * 1.609
}


InchesToCentimeters.convert(1)
GallonsToLiters.convert(2.5)
MilesToKilometers.convert(3.8)

//3
object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

val point = Point(1, 2)

//6.

object Card extends Enumeration {
  type Card = Value
  val SPADE = Value("\u2660")
  val HEART = Value("\u2665")
  val DIAMOND = Value("\u2666")
  val CLUB = Value("\u2663")

}

Card.SPADE.toString
Card.HEART.toString
Card.DIAMOND.toString
Card.CLUB.toString

import Card._

def isRed(card: Card) = card match {
  case i if i == HEART || i == DIAMOND => true
  case _ => false
}

isRed(SPADE)
isRed(HEART)

//8. RGB
object Color extends Enumeration {
  val BLACK = Value(0x000000)
  val WHITE = Value(0xffffff)
  val RED = Value(0xff0000)
  val GREEN = Value(0x00ff00)
  val BLUE = Value(0x0000ff)
  val YELLOW = Value(0xffff00)
  val CYAN = Value(0x00ffff)
  val RUBIN = Value(0xff00ff)


}

Color.BLACK.id
Color.RED
