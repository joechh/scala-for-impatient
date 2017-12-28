import scala.annotation.tailrec

//recursion should specify return type
def fac(n: Int): Int = {
  if (n == 0) 1
  else n * fac(n - 1)
}

@tailrec
def tailFac(n: Int, sum: Int = 1): Int = {
  if (n == 0) sum
  else tailFac(n - 1, sum * n)
}

//function with default arguments
def decorate(str: String, left: String = "[", right: String = "]") =
  left + str + right

decorate("Joe")

//named argument
decorate(str = "Joe", left = "<", right = ">")

//variable argument
def sum(args: Int*) = {
  var results = 0
  for (arg <- args) results += arg
  results
}
sum(1, 2, 3)
sum(1, 2)
//sum(1 to 5)
//make sequence(1 to 5) to be considered as single argument
sum(1 to 5: _*)

def recursiveSum(args: Int*): Int = {
  if (args.length == 0) 0
  else args.head + recursiveSum(args.tail: _*)
}


