class Account private(val id: Int, initialBalance: Double) {
  private var balance = initialBalance

}

object Account {
  var uniqueNumber = 0;

  def apply(initialBalance: Double): Account = {

    new Account(newUniqueNumber(), initialBalance)
  }

  def newUniqueNumber() = {
    uniqueNumber += 1;
    uniqueNumber
  }

}

val account1 = Account(1000)
account1.id
val account2 = Account(1000)
account2.id

//Application object via extending App trait
object Hell extends App{
  if(args.length>0)  //can still access args String Array
    println(s"Hello ${args(0)}")
  else println("Hello World")
}