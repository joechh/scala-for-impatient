class Person(val name: String, val age: Int) {
  var test = 123

  def show = {
    println(s"name:$name, age:$age")
  }
}

class Employee(override val name: String, age: Int, val salary: Double) extends Person(name, age) {
  override val show = {
    println("haha")
  }
  // var cannot be override if it is not abstract
  //override var test=456

}

val joe = new Employee("joe", 33, 10)
joe.show
joe.name
joe.age
joe.salary

abstract class AbstractPerson {
  def id: Int
}

//override parameter-less function with val
class Student(override val id: Int = 0) extends AbstractPerson

//anonymous subclass, its type is Person{def greeting:String}
val doris = new Person("doris", 32) {
  def greeting = "the object of the doris is the subclass of person"

}

//use this special as type in the parameter
def meet(p: Person {def greeting: String}) = {
  println(s"${p.name} says: ${p.greeting}")
}
meet(doris)

class test(var age: Int)

class test2(override var age: Int) extends test(10)