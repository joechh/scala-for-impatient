import java.io._

import scala.io.Source

//7. tokens
var filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex7.txt"
var source = Source.fromFile(filepath)
//val floatPattern ="""^(-?\d+)(\.\d+)?$"""
val floatPattern =
  """(-?\d+.\d+)"""
for (line <- source.getLines()) {
  println(line.replaceAll(floatPattern, ""))
}
source.close()

//8.Skip
//9.


// get all the files from a directory

def getClassNumber(pathStr: String, files: List[File]): List[File] = {
  val dir = new File(pathStr)
  var tempiles = files
  for (file <- dir.listFiles) {
    if (file.isFile && file.toString.contains(".class"))
      tempiles = files :+ file
    else if (file.isDirectory) tempiles = getClassNumber(file.getAbsolutePath, tempiles)
  }
  tempiles
}
val dirpath = "/home/joechh/Scala/scala-for-impatient/target"
val res = getClassNumber(dirpath, List[File]())
res.length

//10.
@SerialVersionUID(42L) class Person(val name: String) extends Serializable {
  var friends = List[Person]()

  def addFriend(friend: Person) = {
    friends = friend +: friends
  }


  override def toString = s"Person($name,$friends)"
}

val joe = new Person("Joe")
val doris = new Person("Doris")
val john = new Person("John")
joe.addFriend(doris)
joe.addFriend(john)
doris.addFriend(john)

val out = new ObjectOutputStream(new FileOutputStream("/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex10.obj"))
out.writeObject(joe)
out.close

val in = new ObjectInputStream(new FileInputStream("/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex10.obj"))
val savedJoe = in.readObject().asInstanceOf[Person]
in.close()
savedJoe








