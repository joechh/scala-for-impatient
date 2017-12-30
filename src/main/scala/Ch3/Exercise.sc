import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}
import scala.collection.mutable.ArrayBuffer

//1.
val n = 10
val a = Array.range(0, n)

//2. val
var array = Array(1, 2, 3, 4, 5)
for (i <- array.indices by 2) {
  if (i != array.length - 1) {
    val tmp = array(i)
    array(i) = array(i + 1)
    array(i + 1) = tmp
  }
}
array

//3.
array = Array(1, 2, 3, 4, 5)
val tmp = for (i <- array.indices by 2) yield {
  if (i == array.length - 1) Array(array(i))
  else Array(array(i + 1), array(i))
}
var res: Array[Int] = tmp.toArray.flatten

//4.
var origin = Array(1, -2, 3, -4, 5, -6)
origin.filter(_ > 0) ++ origin.filter(_ <= 0)

//5.
val doubleArr = Array(2.0, 1.0, 3.0, 4.0)
doubleArr.reduce(_ + _) / doubleArr.length

//6.
doubleArr.sorted.reverse
ArrayBuffer(2.0, 1.0, 3.0, 4.0).sorted.reverse

//7.
def removeDuplicate(x: Array[Int]) = x.distinct
res = removeDuplicate(Array(1, 1, 2, 2, 3, 3, 3))

//8., origin=Array(1, -2, 3, -4, 5, -6)
var originBuffer = origin.toBuffer
val negatives = (for (i <- originBuffer.indices if origin(i) < 0) yield i).toBuffer
negatives.trimStart(1)
for (index <- negatives.reverse) {
  originBuffer.remove(index)
}
originBuffer

//9. move positive elements after unwanted-removed negative elements
originBuffer = origin.toBuffer
var firstNegitiveIndex = -1

for (i <- origin.indices)
  if (origin(i) < 0 && firstNegitiveIndex < 0)
    firstNegitiveIndex = i

val otherKeepElement = for {
  i <- firstNegitiveIndex + 1 to originBuffer.length - 1 if originBuffer(i) > 0
} yield i

for (i <- otherKeepElement.indices)
  originBuffer(firstNegitiveIndex + 1 + i) = originBuffer(otherKeepElement(i))

originBuffer.trimEnd(originBuffer.length - (firstNegitiveIndex + 1) - otherKeepElement.length)

originBuffer

//10.
val AmericaTimeZones = java.util.TimeZone.getAvailableIDs
  .filter(_.contains("America/"))
  .map(_.replace("America/", ""))

//11.
import scala.collection.JavaConverters._

val flavors = SystemFlavorMap.getDefaultFlavorMap
  .asInstanceOf[SystemFlavorMap]
  .getNativesForFlavor(DataFlavor.imageFlavor)
  .asScala