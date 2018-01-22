class Person(val name: String, val age: Int) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[Person]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        name == that.name &&
        age == that.age
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, age)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

val p1 = new Person("joe", 33)
val p2 = new Person("joe", 33)

p1 == p2
p1.eq(p2)
p1.equals(p2)