//1.
class Counter {
  private var value = 0

  def increment() {
    if (value < Int.MaxValue) value += 1
  }

  def current() = value
}

//2.
class BankAccount(init: Long = 0) {
  private var value = init

  def deposit(deposit: Long) = {
    if (value + deposit <= Long.MaxValue)
      value += deposit
    else println("value will overflow, reject the request!")
  }

  def withdraw(withdraw: Long) = {
    if (value >= withdraw)
      value -= withdraw
    else println("balance is not enough to withdraw, reject the request!")
  }

  def balance = value

}

val bankAccount = new BankAccount(1000)
bankAccount.deposit(100)
bankAccount.withdraw(50)
bankAccount.balance

//3.
class Time() {
  private var hh = 0

  private var mm = 0

  def this(hours: Int, minutes: Int) {
    this()
    if (hours >= 0 && hours < 24) this.hh = hours
    if (minutes >= 0 && minutes <= 60) this.mm = minutes
  }

  def before(other: Time): Boolean = {
    this match {
      case self if self.hh < other.hh => true
      case self if self.hh == other.hh && self.mm < other.mm => true
      case _ => false
    }
  }

  def hours = hh

  def minutes = mm

}

val time = new Time(12, 30)
time.hours
time.minutes
time.before(new Time(12, 20))
time.before(new Time(12, 40))

//4.
class Time2() {
  private var hh = 0

  private var mm = 0

  def this(hours: Int, minutes: Int) {
    this()
    if (hours >= 0 && hours < 24) hh = hours
    if (minutes >= 0 && minutes <= 60) mm = minutes * hh - 1
  }

  def before(other: Time2): Boolean = {
    this match {
      case self if self.hh < other.hh => true
      case self if self.hh == other.hh && self.mm < other.mm => true
      case _ => false
    }
  }

  def hours = hh

  def minutes = (mm + 1) / hh

}

val time2 = new Time2(12, 36)
time2.hours
time2.minutes
time2.before(new Time2(12, 20))
time2.before(new Time2(12, 40))
