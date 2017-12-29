import java.time.LocalDate

//1.
def signum(x: Int) = x match {
  case i if i > 0 => 1
  case i if i < 0 => -1
  case i if i == 0 => 0
}
signum(0)
signum(-100)
signum(100)

//2.
val empty = {}

//3.
var x = ()
var y = 1
x = y = 1

//4.
for (i <- 10 to 0 by -1) println(i)

//5.
def countdown(n: Int) = {
  for (i <- n to 0 by -1)
    println(i)
}
countdown(5)

//6.
var product: Long = 1
for (chr <- "Hello") {
  product *= Integer.toUnsignedLong(chr)
}
println(s"product = $product")

//7,8,9
def product(s: String, sum: Long = 1): Long = {
  if (s.isEmpty) sum
  else product(s.tail, Integer.toUnsignedLong(s.head) * sum)
}
product("Hello")

//10.
def powerx(x: Int, n: Int): Double = {
  val positiveN = if (n < 1) -n else n

  def loop(postiveN: Int, sum: Int = 1): Long = {
    if (postiveN == 0) sum
    else loop(postiveN - 1, x * sum)
  }

  val res = loop(positiveN)
  if (n >= 0) res else (1.0 / res)
}
powerx(2, 4)
powerx(2, -4)

//11.
implicit class DataInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = {
    if (args.length != 3) {
      throw new IllegalArgumentException("args.length should be 3")
    }
    else {
      val year = args(0)
      val month = args(1)
      val monthOfDay = args(2)
      LocalDate.of(Integer.parseInt(year.toString),
        Integer.parseInt(month.toString),
        Integer.parseInt(monthOfDay.toString))
    }
  }
}

val year = 2014
val month = 12
val day = 30
date"$year-$month-$day"

