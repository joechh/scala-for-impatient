package Ch8

class Person(val name: String, val age: Int) {

  def this() = {
    this("joe", 30)


  }

}

class Employee(name: String, age: Int, val salary: Double) extends Person {

}

