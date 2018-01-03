package Ch7.Exercise

class HashConverter2 {

  import java.util.{HashMap => JavaHashMap}

  import scala.collection.mutable._

  def toSclaMap(map: JavaHashMap[Any, Any]): HashMap[Any, Any] = {

    val scalaMap = new HashMap[Any, Any]()

    map.forEach((k, v) => scalaMap(k) = v)
    scalaMap

  }


}

object HashConverter2 {
  def apply(): HashConverter2 = new HashConverter2()
}


object Ex7 {
  def main(args: Array[String]): Unit = {
    import java.util.{HashMap => JavaHashMap}
    val converter = HashConverter2()
    val javaMap = new JavaHashMap[Any, Any]()
    javaMap.put(1, 2)
    javaMap.put(3, 4)

    val scalaMap = converter.toSclaMap(javaMap)
    scalaMap.foreach(println)

  }

}
