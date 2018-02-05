trait Logger {
  def log(msg: String)
}

//trait can have concrete methods
trait TraitConsoleLogger {
  def log(msg: String): Unit = println(msg)
}

class SavingAccount(initValue: Double) extends TraitConsoleLogger {
  var balance = initValue

  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}

//object with traits
abstract class AbstractSavingAccount(initValue: Double) extends Logger {
  var balance = initValue

  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }

}

trait ConsoleLogger extends Logger {
  override def log(msg: String): Unit = println(msg)
}

trait FileLogger extends Logger {
  override def log(msg: String): Unit = println(s"save $msg to file...")
}

val acctConsole = new AbstractSavingAccount(100) with ConsoleLogger
val acctFile = new AbstractSavingAccount(100) with FileLogger

//chain the trait in the same method name
trait TimeStampLogger extends ConsoleLogger {
  override def log(msg: String): Unit = {
    super.log(s"${java.time.Instant.now()} $msg")
  }
}

trait ShortLogger extends ConsoleLogger {
  //override def log(msg: String): Unit = super[ConsoleLogger].log(
  override def log(msg: String): Unit = super.log(
    if (msg.length <= 15) msg else s"${msg.substring(0, 12)}"

  )
}

val acct1 = new AbstractSavingAccount(100) with TimeStampLogger with ShortLogger
val acct2 = new AbstractSavingAccount(100) with ShortLogger with TimeStampLogger

acct1.withdraw(120)
acct2.withdraw(120)


trait A {
  def testMethod:Unit
}

trait B {
  def testMethod = {
    println("method in trait B ")
  }
}

class TestClass extends B with A

val t = new TestClass
t.testMethod