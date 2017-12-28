import scala.annotation.tailrec

var r = 10
var n = 5

//while
while (n > 0) {
  r = r * n;
  println(r)
  n -= 1
}

r = 10
n = 5
//for expression
for (i <- 1 to n) {
  r = r * i
  println(r)
}

val s = "Hello"
var sum = 0
for (i <- 0 to s.length - 1) {
  sum += s(i)
}

//another expression
for (char <- "Hello") {
  sum += char
}

//Local variable(ex: x) overlapping in the same scope
val x = "Hello"
for (x <- 1 to 10) println(x)

for (i <- 2 to 4; j <- 4 to 5) println(f"${10 * i + j}")

//with guard
for (i <- 2 to 4; j <- 4 to 5 if i != j) println(f"${10 * i + j}%3d")

//yields(for comprehension)
for (i <- 1 to 10) yield i % 3

for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar


