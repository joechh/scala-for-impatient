import scala.collection.mutable.ArrayBuffer

//An array of ten integers, all elements are initialized to be 0
val nums = new Array[Int](10)
nums(0)
nums(1)
//An array of ten strings, all elements are initialized to be null
val strs = new Array[String](10)
strs(0)
strs(1)
val s = Array("Hello", "Joe")
s(0) = "Good Bye"

val b = ArrayBuffer[Int]()
val c = new ArrayBuffer[Int]

//use += to append one or more element
b += 1
b += (2, 3, 4)

//use +=: to prepend an element
2 +=: b

//use ++= to append a collection
b ++= Array(1, 2, 3)

//use ++=: to prepend a collection
Array(0, 0) ++=: b

//trimming functions
b.trimStart(2)
b.trimEnd(3)

var numsBuffer = ArrayBuffer[Int]()
var t0 = System.currentTimeMillis()
//Appending into array, fast
for (i <- 1 to 100000) {
  numsBuffer += i
}
var t1 = System.currentTimeMillis()
println(s"elapsed time = ${t1 - t0} millis second")

numsBuffer = ArrayBuffer[Int]()
t0 = System.currentTimeMillis()
//Prepending into array, slow(because whole elements should be moved)
for (i <- 1 to 100000) {
  i+=:numsBuffer
}
t1 = System.currentTimeMillis()
println(s"elapsed time = ${t1 - t0} millis second")

b.insert(2,6)
b
b.insert(2,6,7,8)
b