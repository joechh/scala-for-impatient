val map = scala.collection.mutable.Map(1 -> "ten", 2 -> "twenty")
map(3) = "thirty"
map(2) = "TWENTY"

//use += to add multiple associations
map += (4 -> "fourty", 5 -> "fifty")
map -= 3
val scores = Map("Alice" -> 20, "Bob" -> 25)

//updating the value of "Bob" in immutable map by creating a new one with different value for "Bob"
val newScores = scores + ("Bob" -> 10, "Fred" -> 7)
newScores

//Remove
val removeBob = newScores - "Bob"

//Iterating over map
for ((k, v) <- map) println(s"key is: $k and value is: $v")

//which is equal to ...
for (kv <- map) println(s"key is: ${kv._1} and value is: ${kv._2}")

//key sets
map.keys
map.keySet

//values
map.values

//sortedMap
scala.collection.immutable.SortedMap("Bob" -> 10, "Alice" -> 30, "Joe" -> 50)

import java.util

import scala.collection.JavaConverters._

var treemap = new java.util.TreeMap[String, Int]()
//Java Tree Map -> Scala map
val tree2Map: scala.collection.mutable.Map[String, Int] = treemap.asScala

//Java Property -> Scala map
val property2Map: scala.collection.mutable.Map[String, String] = System.getProperties.asScala


//Scala map -> Java map
import java.awt.font.TextAttribute._
val attrs = Map(FAMILY -> "Serif", SIZE -> 12)
val font = new java.awt.Font(attrs.asJava)