package Ch2

import scala.io._

object StdInDemo {
  def main(args: Array[String]): Unit = {

    val myname = StdIn.readLine("your name:")
    println(s"my name is $myname")

    print("your age:")
    val myage = StdIn.readInt()
    print(s"my age is $myage years old")
    val n ="abc"
    for(n<-1 to 10) println(n)
  }

}
