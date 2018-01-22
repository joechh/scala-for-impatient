

//1.
class BanckAccount(initBalance: Double) {
  private var balance = initBalance

  def currentBalance = balance

  def deposit(amount: Double): Double = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount;
    balance
  }
}

class AmountNotEnoughException extends Exception

//2.
class CheckingAccount(initBalance: Double) extends BanckAccount(initBalance) {
  val fee: Int = 1

  override def deposit(amount: Double): Double = {
    if (amount < fee)
      throw new AmountNotEnoughException
    else
      super.deposit(amount - fee)
  }

  override def withdraw(amount: Double): Double = {
    if (amount < fee)
      throw new AmountNotEnoughException
    else
      super.withdraw(amount - fee)
  }

}

val account = new CheckingAccount(100)
account.deposit(100)
account.withdraw(100)

//3.
class SavingAccount(initBalance: Double) extends CheckingAccount(initBalance) {
  val interest: Double = 100
  var freeTransaction = 3

  def earnMonthlyInterest(): Double = {
    freeTransaction = 3
    interest
  }

  override def deposit(amount: Double) = {
    if (freeTransaction > 0) {
      freeTransaction -= 1
      super.deposit(amount + fee)
    }
    else
      super.deposit(amount)
  }


  override def withdraw(amount: Double) = {
    if (freeTransaction > 0) {
      freeTransaction -= 1
      super.withdraw(amount + fee)
    }
    else
      super.withdraw(amount)

  }
}

val savingAccount = new SavingAccount(100)
savingAccount.deposit(10)
savingAccount.deposit(10)
savingAccount.deposit(10)
savingAccount.deposit(10)
savingAccount.earnMonthlyInterest()
savingAccount.deposit(10)

//4.
abstract class Item {
  def price: Double

  val description: String

}

class SimpleItem(val price: Double, val description: String) extends Item {

}

class Bundle(item1: Item, item2: Item) extends Item {
  override def price = item1.price + item2.price

  override val description = {
    s"${item1.description}\n${item2.description}"
  }
}

val bundle = new Bundle(new SimpleItem(10, "A"), new SimpleItem(20, "B"))
bundle.price
bundle.description

//5.
case class Point(val x: Int, val y: Int)

class LabelPoint(val lable: String, x: Int, y: Int) extends Point(x, y)

//6.
abstract class Shape {
  def centerPoint: Point
}

class Rectangle(val p1: Point, val p2: Point) extends Shape {
  override def centerPoint: Point = {
    new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)
  }
}

class Circle(val p1: Point, val radius: Int) extends Shape {
  override def centerPoint: Point = p1
}

val shape: Shape = new Rectangle(Point(1, 2), Point(3, 4))
shape.centerPoint
val circle: Shape = new Circle(Point(1, 2), 20)
circle.centerPoint
