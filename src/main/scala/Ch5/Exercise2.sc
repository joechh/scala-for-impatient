//6.
class Person(OriginalAge: Int) {
  var age = if (OriginalAge < 0) 0 else OriginalAge

}

val p61 = new Person(-100)
p61.age
val p62 = new Person(100)
p62.age

//7.
class Person7(NameString: String) {
  val firstName = NameString.split(" ")(0)
  val secondName = NameString.split(" ")(1)
}

val p71 = new Person7("Hsu Joe")
p71.firstName
p71.secondName

//8.Car
class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {
  def this(mf: String, mn: String, lp: String) {
    this(manufacturer = mf, modelName = mn, licensePlate = lp)
  }

  override def toString = s"Car($manufacturer, $modelName, $modelYear, $licensePlate)"
}

val car81 = new Car("testManufacturer", "testModel")
var car82 = new Car("testManufacturer", "testModel", 2016)
var car83 = new Car("testManufacturer", "testModel", 2017, "testPlate")
var car84 = new Car("testManufacturer", "testModel", "testPlate")
car81.manufacturer
car81.modelName
car81.modelYear
car81.licensePlate
car81.licensePlate = "modified license"
car81

//10.
class OriginalEmploy(val name: String, var salary: Double) {
  def this() {
    this("John Q. Public", 0.0)
  }
}

val employ1 = new OriginalEmploy()
employ1.name
employ1.salary
employ1.salary = 20

class Employ(val name: String = "John Q. Public", var salary: Double = 0.0)

val employ = new Employ
employ.name
employ.salary
employ.salary = 20



