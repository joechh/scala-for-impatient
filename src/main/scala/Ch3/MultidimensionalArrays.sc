val matrix = Array.ofDim[Int](3, 4)
matrix.foreach(array => {
  array.foreach(ele => print(s"$ele "))
  println()
})

matrix(0)(1) = 20
matrix(0)(1)

val a = Array("Mary", "a", "had", "lamb")
//java.util.Arrays.binarySearch(a) //does not work
java.util.Arrays.binarySearch(a.asInstanceOf[Array[Object]], "abc")

import scala.collection.Searching._

Array(1, 2, 3, 4, 5).search(3)
Array(1, 2, 3, 5).search(4)

