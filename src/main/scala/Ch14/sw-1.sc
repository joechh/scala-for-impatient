//14.1
val ch: Char = '1'
var sign = 0
sign = ch match {
  case '+' => 1
  case '-' => -1
  case _ => 0
}

var digit = 0
val x = '1'
ch match {
  case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
  case `x` => digit = -2
  case '+' => 1
  case '-' => -1
  case _ => 0
}

digit

//14.5
class Test(val count: Int)

object Test {
  def apply(val count: Int):Test ={
    new Test(count)
  }

}

val t1 = Test
val t2 = new Test(100)

def test(t: Any) {
  t match {
    case _: Test => println("Class Test")
    case Test => println("Object Test")
  }
}
test(t2)
test(t1)





val array = Array(1, 2, 3)
array match {
  case Array(x, rest@_*) => println(rest.min)
}

val pattern = "([0-9]+) ([a-z]+)".r
"99 bottles" match {
  case pattern(num, item) => println(s"$num:$item")
}

val (q, r) = BigInt(10) /% 3
val Array(first, second, rest@_*) = Array(1, 2, 3, 4)

val xx = 3
val 2 = xx

class Amount(val amount: Double)

case class Dollar(value: Double) extends Amount(value)

case class Currency(value: Double, unit: String) extends Amount(value)

case object Nothing extends Amount(0)

val amt = new Amount(100)
//amt match {
//  case Dollar(v) => println(s"$$$v")
//  case Currency(_, u) => println(s"Oh noes, Igout $u")
//  case Nothing => println("")
//  case _ => println("haha")
//
//}

