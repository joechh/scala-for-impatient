

def show(o: Any): Unit = {
  println(s"${o.getClass}:$o")
}
show(3)

show(3, 4, 5, 6) //the parameters are seemed to a tuple

class Item(val description: String, val price: Double) {
  final override def equals(that: scala.Any) = that match {
    case that: Item => description == that.description && price == that.price
  }
}

val item1 = new Item("A", 10)
val item2 = new Item("A", 20)
val item3 = new Item("A", 10)
item1 == item2
item1 == item3

