import scala.collection.mutable.ArrayBuffer

Array(1, 2, 3).sum
Array(1, 2, 3).max
Array(1, 2, 3).min
var b = Array(1, 3, 2, -1, 4).sorted
b = Array(1, 3, 2, -1, 4).sortWith(_ > _)

//sorting in place(only for array, does not support arrayBuffer)
scala.util.Sorting.quickSort(b)
b

//display the contents of array
b.mkString("[", "-", "]")
b.mkString(",")

//toString method in array and arrayBuffer
b.toString
b.toBuffer.toString