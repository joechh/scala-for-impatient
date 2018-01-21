import java.io.File
import java.util.Calendar._
import java.util.Scanner

import scala.collection.mutable
import scala.util.Random

//1.
val gizmos = Map("Camera" -> 15000, "Iphone" -> 30000, "NB" -> 55000)
val discount = gizmos.mapValues(_ * 0.9)

//2. using mutable map to make wordcount
val wordcount = scala.collection.mutable.Map[String, Int]()
var in = new Scanner(new File("/home/joechh/test.file"))
while (in.hasNext()) {
  val key = in.next()
  if (wordcount.contains(key))
    wordcount(key) = wordcount(key) + 1
  else
    wordcount(key) = 1
}
wordcount.foreach(kv => println(s"${kv._1}:${kv._2}"))

//3 using immutable map
var wordcount2 = Map[String, Int]()
in = new Scanner(new File("/home/joechh/test.file"))
while (in.hasNext()) {
  val key = in.next()
  if (wordcount2.contains(key))
    wordcount2 += (key -> (wordcount2(key) + 1))
  else
    wordcount2 += (key -> 1)
}
wordcount.foreach(kv => println(s"${kv._1}:${kv._2}"))

//4. using sorted Map
var sortedMap = scala.collection.immutable.SortedMap[String, Int]()
in = new Scanner(new File("/home/joechh/test.file"))
while (in.hasNext()) {
  val key = in.next()
  if (sortedMap.contains(key))
    sortedMap += (key -> (sortedMap(key) + 1))
  else
    sortedMap += (key -> 1)
}
sortedMap.foreach(kv => println(s"${kv._1}:${kv._2}"))

//5.using java TreeMap and Scala API
import scala.collection.JavaConverters._

var treeMap = new java.util.TreeMap[String, Int]()
in = new Scanner(new File("/home/joechh/test.file"))
while (in.hasNext()) {
  val key = in.next()
  if (treeMap.asScala.contains(key))
    treeMap.asScala += (key -> (treeMap.asScala(key) + 1))
  else
    treeMap.asScala += (key -> 1)
}
sortedMap.foreach(kv => println(s"${kv._1}:${kv._2}"))

//6.LinkedHashMap
val linkedHashMap = mutable.LinkedHashMap[String, Int]()

linkedHashMap += (
  "Monday" -> MONDAY
  , "TuesDay" -> TUESDAY
  , "WednesDay" -> WEDNESDAY
  , "Thursday" -> THURSDAY
  , "Saturday" -> SATURDAY
  , "Friday" -> FRIDAY
  , "Sunday" -> SUNDAY
)
linkedHashMap.foreach(kv => println(s"${kv._1}: ${kv._2}"))

//7. Print Properties
val propertiesMap = System.getProperties.asScala
def findMax(x: Int, y: String): Int = {
  math.max(x, y.length)
}
val maxLength: Int = propertiesMap.keySet.foldLeft(0)(findMax)
val maxPadLength = maxLength + 5
propertiesMap.foreach(kv => {
  val key = kv._1
  val value = kv._2
  val blank = " " * (maxPadLength - key.length)
  println(s"$key$blank|$value")
})

//8. Implement minmax via fold and simple array function
def minmax1(values: Array[Int]) = values.foldLeft(Int.MaxValue, Int.MinValue)((acc, newValue) => {
  (math.min(acc._1, newValue), math.max(acc._2, newValue))
})

def minmax2(values: Array[Int]) = (values.min, values.max)
def evaluation(f: (Array[Int]) => (Int, Int), data: Array[Int]): Unit = {
  val t0 = System.currentTimeMillis()
  val (min, max) = f(data)
  val t1 = System.currentTimeMillis()
  println(f.getClass.getSimpleName)
  println(s"elapse: ${t1 - t0} millis,min=$min and max=$max")
}
val testData = Seq.fill(2000)(Random.nextInt)
evaluation(minmax1, testData.toArray)
evaluation(minmax2, testData.toArray)

//9.
def lteqgt(values: Array[Int], v: Int) = {
  (values.count(_ < v), values.count(_ == v), values.count(_ > v))
}
val v = testData(Random.nextInt(testData.length))
lteqgt(testData.toArray, v)

//10.
"Hello".zip("World")
"Longer world".zip("short")
"short".zip("Longer world")