package Ch7.Exercise

import java.util.{HashMap => JavaHashMap}

import scala.collection.mutable._

class HashConverter {
  def toSclaMap(map: JavaHashMap[Any, Any]): HashMap[Any, Any] = {
    val scalaMap = new HashMap[Any, Any]()

    map.forEach((k, v) => scalaMap(k) = v)
    scalaMap

  }


}

object HashConverter {
  def apply(): HashConverter = new HashConverter()
}


object Ex6 {
  def main(args: Array[String]): Unit = {
    val converter = HashConverter()
    val javaMap = new JavaHashMap[Any, Any]()
    javaMap.put(1, 2)
    javaMap.put(3, 4)

    val scalaMap = converter.toSclaMap(javaMap)
    scalaMap.foreach(println)

  }

}
