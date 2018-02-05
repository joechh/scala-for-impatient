//10.6 Overriding Abstract Methods in Traits //
//Should be abstract also if call super method
trait Logger {
  def log(msg: String)
}

//Error, super.log has no implementation
//trait TimeStampLogger extends Logger {
//  override def log(msg: String): Unit = {
//    super.log(s"${java.time.Instant.now()} $msg")
//  }
//}

trait ShortLogger extends Logger {
  abstract override def log(msg: String) {
    super.log(if (msg.length <= 15) msg else s"${msg.substring(0, 12)}")
  }
}

abstract class Test extends Logger {
  def haha(str: String): Unit = {
    log(str)
  }
}

