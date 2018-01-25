import java.io.PrintWriter

import scala.io.Source

//1.
var filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/myfile.txt"
var source = Source.fromFile(filepath, "UTF-8")
var lineIt = source.getLines()

var outputFilepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex1out.txt"
var out = new PrintWriter(outputFilepath)
for (line <- lineIt.toList.reverse)
  out.println(line)
source.close
out.close

//2.
filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/tab.txt"
source = Source.fromFile(filepath)
lineIt = source.getLines()
val tabPattern = "\\t".r
val res = lineIt.map(x => tabPattern.replaceAllIn(x, " "))
outputFilepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/tabOut.txt"
out = new PrintWriter(outputFilepath)
for (line <- res)
  out.println(line)

source.close()
out.close()


//3
filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex3.txt"
source = Source.fromFile(filepath)
lineIt = source.getLines()
val wordPattern ="""[a-zA-Z0-9]{8,}""".r
lineIt.foreach(x => wordPattern.findAllIn(x).foreach(println))
source.close()

//4.
filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex4.txt"
source = Source.fromFile(filepath)
lineIt = source.getLines()
val d = lineIt.flatMap(_.split("\\s+")).map(_.toDouble).toList
(d.max, d.min, d.sum, d.sum / d.size)
source.close()

//5.
filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex5.txt"
val printWriter = new PrintWriter(filepath)
for (i <- 0 to 20) {
  val str = f"${Math.pow(2, i).toInt}%-10d   ${1 / Math.pow(2, i)}%-15f"
  printWriter.println(str)
  println(str)
}
printWriter.flush()
printWriter.close() //close = flush + call close() method

//6.
filepath = "/home/joechh/Scala/scala-for-impatient/src/main/scala/Ch9/files/Ex6.txt"
source = Source.fromFile(filepath)
lineIt = source.getLines()
val ex6Pattenr ="""\"\w+""".r
val ex6=(for {
  line <- lineIt
  matching <- ex6Pattenr.findAllIn(line)
}yield matching).toList


