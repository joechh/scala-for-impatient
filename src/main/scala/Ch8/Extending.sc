abstract class Person {
  def show(): Unit = {
    println("show in Person")
  }

  def abstractShow(): Unit

}

class Employee extends Person {
  override def show(): Unit = {
    println("need override modifier")
  }

  def abstractShow(): Unit = {
    println("do not need to override modifier")
  }

  override def toString = s"${super.toString} is an employee"
}


val p = new Person {
  override def abstractShow(): Unit = println("haha")
}

null.asInstanceOf[Employee]
p.isInstanceOf[Employee]
//p.asInstanceOf[Employee] ClassCastException

//100% exactly the same as Employee class
((new Employee).getClass == classOf[Employee])
(p.getClass == classOf[Employee])

//better solution for type check and casting: pattern match
p match {
  case _: Employee => ??? //do sth
  case _ => ??? //do sth
}
