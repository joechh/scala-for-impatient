val array = Array(1, 2, 3, 4, 5, 6)

// for/yield
var newArray = for (i <- array) yield i * 2

//map version
newArray = array.map(_ * 2)

//for with guard
for (i <- array if i % 2 == 0) print(s"$i ")

//filter version
array.filter(_ % 2 == 0).foreach(i => print(s"$i "))

val arrayBuf = array.toBuffer
val positionEven = for (i <- arrayBuf.indices if arrayBuf(i) % 2 == 0) yield i
for (i <- positionEven.indices) arrayBuf(i) = arrayBuf(positionEven(i))
arrayBuf.trimEnd(array.length - positionEven.length)
arrayBuf