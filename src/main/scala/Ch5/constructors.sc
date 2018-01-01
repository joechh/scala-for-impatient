
class Person {
  private var name = ""
  private var age = 0

  def this(name: String) = { //Auxiliary Constructor
    this() //Primary Constructor
    this.name = name
  }

  def this(name: String, age: Int) { //Auxiliary Constructo
    this(name)
    this.age = age
  }
}

val p1 = new Person
val p2 = new Person()
val p3 = new Person("Joe")
val p4 = new Person("Joe", 34)


class CalculatorWithConstruct(var brand: String) {
}

val anotherCalc = new CalculatorWithConstruct("Apple")
anotherCalc.brand

class ScientificCalculator(brand: String, val cost: Int) extends CalculatorWithConstruct(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

val sciCalc = new ScientificCalculator("IBM", 100)
sciCalc.log(100, 10)
sciCalc.brand
sciCalc.cost

class Person2(val name: String, val age: Int) {
  println("This  println() would be executed when object is initialized")
}

val person2 = new Person2("Joe", 33)

//Usually can eliminate auxiliary constructors by using default arguments in the primary constructors
class Person3(val name: String = "", val age: Int = 0)

val person31 = new Person3()
val person32 = new Person3("Doris")
val person33 = new Person3(age = 33)

//inner object-private fields (like private[this]) when without var/val
class Person4(name: String, age: Int) {
  def print() = println(s"name is $name, and age is $age")
}

//private primary constructor
class Person5 private(val id: Int) {
  def this(numStr: String) = {
    this(numStr.toInt)
  }
}

val person51 = new Person5("123")