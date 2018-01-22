abstract class Person {
  val id: Int
  var name: String
}

class Employee(val id: Int, var name: String) extends Person {

}

class Employee2 extends Person {
  override val id = 20
  override var name = "Fred"
}

//anonymous subclass
val fred = new Person {
  val id: Int = 20
  var name: String = "Fred"
}

class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2

}

val ant = new Ant
//Construction Order and Early Definitions Problem
//ant.env.length=0
ant.env.length

//sol1.
// lazy val env: Array[Int] = new Array[Int](range) in Creature

//sol2.
//early definition syntax in the subclass
class EarlyAnt extends {
  override val range = 3
  override val env = Array(1, 2, 3, 4)
  val test: Int = 4
} with Creature {


}

val earlyAnt = new EarlyAnt
earlyAnt.env.length

def abc(x: Int) = {
  ???
}
//abc(2)

def printAny(x:Any): Unit ={
  println(x)
}

def printUnit(x:Unit): Unit ={
  println(x)
}

printAny("Hello")
printUnit("Hello")