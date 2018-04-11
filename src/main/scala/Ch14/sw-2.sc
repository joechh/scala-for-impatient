
Array(0, 1, 2) match {
  case Array(0) => println("test")
  case _ => println("default value")
}

val list = List(1, 2, 3)
//val tailList = list.tail
list match {
  case 1 :: tail => println(s"$tail")
}

(1, 0) match {
  case (_, 0) | (0, _) => println(_:Int)
}

3::List(1,2,3)
3+:List(1,2,3)