package Ch6

//ex.5
//Input argument: Hello World
//Output: World Hello
object Reverse extends App {
  args.reverse.foreach(arg => print(s"$arg "))
}