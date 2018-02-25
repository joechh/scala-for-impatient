import java.io.IOException

//11.12 Traits Extending Classes
trait Logger {
  def log(msg: String): Unit
}


trait ConsoleLogger extends Logger {
  override def log(msg: String): Unit = println(msg)
}


trait LoggedException extends Exception with ConsoleLogger {
  def log(): Unit = {
    log(getMessage)
  }
}

//max-in
class UnhappyExceptionMixIn1 extends LoggedException {
  override def getMessage = "arggh!!"
}

//Extending the class which is the subclass of the trait's superclass is fine
class UnhappyExceptionMixIn2 extends IOException with LoggedException

//Cannot
//class UnhappyExceptionMixIn3 extends JFrame with LoggedException

//self type
trait LoggedExceptionWithSelfType extends ConsoleLogger {
  this: Exception =>
  def log() {
    log(getMessage)
  }
}

//Cannot
//val f = new JFrame with LoggedException

trait LoggedExceptionWithStructuralType extends ConsoleLogger {
  this: {def getMessage(): String} =>
  def log() {
    log(getMessage)
  }
}