import java.io._

import scala.io.Source

//read by line
val filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/myfile.txt"
var source = Source.fromFile(filepath, "UTF-8")
val lineIt = source.getLines()
for (line <- lineIt) println(line)
source.close()

//make whole content as a string
source = Source.fromFile(filepath, "UTF-8")
source.mkString
source.close()

//read characters
source = Source.fromFile(filepath, "UTF-8")
for (c <- source) println(c)
source.close()

//peek
source = Source.fromFile(filepath, "UTF-8")
val iter = source.buffered
while (iter.hasNext) {
  if (iter.head == 'T') { //would not consume the char
    println("I am in the head of line")
  }
  iter.next()
}
source.close()

//token
source = Source.fromFile(filepath, "UTF-8")
val tokens = source.mkString.split("\\s+")
source.close()

//read from stdIn
print("how old are you?")
//val age = StdIn.readInt()
//println(s"age=$age")

//read from string, useful for debug
val bufferSource = Source.fromString("abc")
bufferSource.getLines().foreach(println)


//write vai PrintWriter
val inputFilePath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/myfile.txt"
val outputFilepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/output.txt"
val in = Source.fromFile(inputFilePath)
val out = new PrintWriter(outputFilepath)

for (line <- in.getLines()) out.println(line)
in.close
out.close

//Visiting Directory
val dirname = "/home/joechh/Scala"
val dir = new File(dirname)
val entries = dir.listFiles
entries.foreach(println)

//Serialization & Deserialization
@SerialVersionUID(42) class Person(val name: String, val age: Int) extends Serializable

val joe = new Person("joe", 33)
val outObject = new ObjectOutputStream(new FileOutputStream("/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/test.obj"))
outObject.writeObject(joe)
outObject.close()
val inObject = new ObjectInputStream(new FileInputStream("/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/test.obj"))
val savedJoe = inObject.readObject().asInstanceOf[Person]
savedJoe.age
savedJoe.name


