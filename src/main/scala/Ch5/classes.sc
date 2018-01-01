import Ch5.Person

import scala.beans.BeanProperty

class Counter {
  //private[this] var value = 0
  private var value = 0


  def increment() = value += 1

  def current = value

  def compare(other: Counter) = {
    println(other.value) //can't access if value is with qualifier private[this]
  }
}

val myCounter = new Counter
//( ) is  considered to be uses when function changes object statue
myCounter.increment()

//( ) is considered to omitted when it is like ana "accessor"
myCounter.current

val person = new Person
//short for .age_=
person.age = 20
person.age_=(21)
println(person.age)

//redefine default getter/setter
class Person2 {
  private var privateAge = 0

  def age = privateAge

  def age_=(newValue: Int): Unit = {
    if (newValue > privateAge) privateAge = newValue //Can't get younger
  }


}

val joe = new Person2
joe.age_=(30)
joe.age = 21
joe.age
joe.age_=(31)
joe.age

class PersonBean {
  @BeanProperty var name: String = _
}

val personBean = new PersonBean
//normal getter/setter also given
personBean.name_=("Doris")
personBean.name

//Java-Bean getter/setter
personBean.setName("Joe")
personBean.getName
