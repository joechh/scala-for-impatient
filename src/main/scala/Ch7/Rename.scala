package Ch7

import java.util.{Hashtable => JavaHashTable, HashMap => _, _}

import scala.collection.immutable.HashMap


class Rename {
  val javaTable = new JavaHashTable[String, Int](10)
  val scalaMap = HashMap
  val javaSet = new HashSet[String]()

}
