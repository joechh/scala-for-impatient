

//10.8 Concrete Fields in Trait
trait Logger {
  def log(msg: String): Unit
}


trait ConsoleLogger extends Logger {
  override def log(msg: String): Unit = println(msg)
}

trait ShortLogger extends ConsoleLogger {
  val maxLength = 15

  override def log(msg: String): Unit = super.log(
    if (msg.length <= maxLength) msg else s"${msg.substring(0, 12)}"

  )
}

class Account {
  var balance = 0.0
}

class SavingsAccount(initValue: Int) extends Account with ConsoleLogger with ShortLogger {
  balance = initValue //inherits
  var interest = 0.0 //plain class field

  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}
