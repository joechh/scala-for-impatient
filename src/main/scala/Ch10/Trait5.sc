import java.io.PrintWriter
//10.11

trait Logger {
  def log(msg: String): Unit
}


trait FileLogger extends Logger {
  val fileName: String
  val out = new PrintWriter(fileName)

  override def log(msg: String): Unit = {
    out.println(msg);
    out.flush()
  }
}

class Account {
  var balance = 0.0
}

class SavingsAccount(initValue: Int) extends Account {
  val maxLength = 10
  balance = initValue //inherits
  var interest = 0.0 //plain class field

}

//! NullPointException! name can't be null
//Construct order: Account->SavingsAccount->Logger
//->FileLogger->self(anonymous subclass)//
//val acc = new SavingsAccount(100) with FileLogger {
//  override val fileName = "test.log"
//}

val acc2 = new {
  override val fileName = "test.log"
} with SavingsAccount(100) with FileLogger

