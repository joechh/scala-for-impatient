import java.io.{BufferedInputStream, FilterInputStream}

//8
trait PrintMachine {
  def printout(msg: String) = println(msg)
}

trait Repeater extends PrintMachine {
  val repeatNum = 3

  override def printout(msg: String): Unit = {
    super.printout(msg * repeatNum)
  }
}

trait Cutter extends PrintMachine {
  val cutRatio: Int

  override def printout(msg: String): Unit = {
    super.printout(msg.substring(0, msg.length / cutRatio))
  }
}

class Log1 extends Repeater with Cutter {
  override val cutRatio = 2
}

class Log2 extends Cutter with Repeater {
  override val cutRatio = 3
}

val log1 = new Log1
log1.printout("abcd")

val log2 = new Log2
log2.printout("abcd")

}
