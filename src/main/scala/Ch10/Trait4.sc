import java.io.PrintWriter

//10.9 Concrete Fields in Trait
trait Logger {
  def log(msg: String): Unit
}


trait ConsoleLogger extends Logger {
  override def log(msg: String): Unit = println(msg)
}

trait ShortLogger extends ConsoleLogger {
  val maxLength: Int

  override def log(msg: String): Unit = super.log(
    if (msg.length <= maxLength) msg else s"${msg.substring(0, 12)}"

  )
}

class Account {
  var balance = 0.0
}

//should supply the maxLength field
abstract class SavingsAccount(initValue: Int) extends Account with ConsoleLogger with ShortLogger {

  val maxLength = 10

  balance = initValue //inherits
  var interest = 0.0 //plain class field
  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}

abstract class SavingAccount2 extends Account with Logger
//mix-in, should override abstract field maxLength
val acct = new SavingAccount2 with ConsoleLogger with ShortLogger {
  override val maxLength = 1
}


trait FileLogger extends Logger {
  val out = new PrintWriter("app.log")
  out.println(s"# ${java.time.Instant.now()}")

  override def log(msg: String): Unit = {
    out.println(msg)
    out.flush()
  }
}

//Construct Order:
//1. Account (superclass)
//2. Logger (the parent of first trait)
//3. FileLogger (first trait)
//4. ShortLogger (second trait)
//5. SavingAccount (the class)
//6. Construct Order is the reverse of the linerization
class SavingAccountToFile extends Account with FileLogger with ShortLogger {
  override val maxLength = _
}



