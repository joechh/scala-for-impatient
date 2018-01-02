class Account {
  val id = Account.getUniqueNumber()
  private var balance = 0.0

  def deposit(amount: Double) {
    balance += amount
  }

}

object Account {
  private var lastNumber = 0

  private def getUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }
}

//the example of using object to be a shared default object
abstract class UndoableAction(val description: String) {
  def undo(): Unit

  def redo(): Unit
}

object DoNothing extends UndoableAction("Do nothing") {
  override def undo(): Unit = {} //do nothing

  override def redo(): Unit = {}
}

//then DoNothing object could be shared as the default action
val actions = Map("open" -> DoNothing, "save" -> DoNothing)