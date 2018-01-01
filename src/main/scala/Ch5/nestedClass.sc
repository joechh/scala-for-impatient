import scala.collection.mutable.ArrayBuffer

class Network {
  outer => //leave the outer reference
  val name = "haha"

  class Member(val name: String) {
    //val contacts = new ArrayBuffer[Network#Member]
    val contacts = new ArrayBuffer[Member]
    this.name //Network.Member.name
    outer.name //Network.name
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

//chatter.Member and myFace.Member is different
val chatter = new Network
val myFace = new Network

val fred = chatter.join("Fred")
val wilma = chatter.join("Wilma")
fred.contacts += wilma //OK
val barney = myFace.join("Barney")

//fred.contacts += barney //type mismatch: myFace.Member !=chatter.Member

class Network2 {


  private val members = new ArrayBuffer[Network2.Member2]

  def join(name: String) = {
    val m = new Network2.Member2(name)
    members += m
    m
  }
}

object Network2 {

  class Member2(val name: String) {
    val contacts = new ArrayBuffer[Member2]
  }

}

val chatter2 = new Network2
val myFace2 = new Network2

val fred2 = chatter2.join("Fred")
val wilma2 = chatter2.join("Wilma")
fred2.contacts += wilma2 //OK
val barney2 = myFace2.join("Barney")
fred2.contacts += barney2 //OK, all are Networks.Member2