//11.8 Extractor
class Fraction(val n: Int, val d: Int) {
  def *(that: Fraction) = {
    Fraction(this.n * that.n, this.d * that.d)
  }

}

object Fraction {
  def unapply(fraction: Fraction) = {
    if (fraction.d == 0) None else Some(fraction.n, fraction.d)
  }

  def apply(n: Int, d: Int): Fraction = new Fraction(n, d)
}

var Fraction(a, b) = Fraction(3, 4) * Fraction(2, 5)

var author = "Joe Hsu"

object Name {
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else {
      Some((input.substring(0, pos), input.substring(pos + 1)))
    }
  }


}

val Name(first, last) = author

//11.9 extractors with one or no arguments
object Iscompound {
  def unapply(input: String): Boolean = input.contains(" ")
}

author = "Joe Hsu Ya"
author match {
  case Name(first, Iscompound()) => print("compound")
  case Name(first, last) => print(first + " : " + last)
}

//11.10 unapplySeq
object Name2 {
  def unapplySeq(input: String): Option[Seq[String]] = {
    if (input.trim == "") None else Some(input.split("\\s+"))
  }
}

author match {
  case Name2(first, "Hsu", "Ya") => print("test unapplySeq")
}

//11.11 Dynamic Invocation

import scala.language.dynamics

class DynamicProcss(val pros: java.util.Properties) extends Dynamic {
  def updateDynamic(name: String)(value: String): Unit = {
    pros.setProperty(name.replaceAll("_", "."), value)
  }

  def selectDynamic(name: String) = {
    pros.getProperty(name.replaceAll("_", "."))
  }

  def applyDynamicNamed(name: String)(args: (String, String)*): Unit = {
    if (name != "add") throw new IllegalArgumentException
    for ((k, v) <- args)
      pros.setProperty(k.replaceAll("_", "."), v)
  }
}

val sysPros = new DynamicProcss(System.getProperties)
sysPros.username = "Joe"
println(sysPros.username)
sysPros.add(age = "30", balance = "50")
sysPros.age
sysPros.balance











