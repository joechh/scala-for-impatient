import scala.collection.mutable.ArrayBuffer

//counting with predicate function
var b = Array(1, 3, 2, -1, 4)
b.count(_ >= 3)

//append & appendAll
val c = b.toBuffer
b
c.append(5)
c
c.appendAll(Array(-10, -100, -1000))
c

//containSlice
c.containsSlice(Array(-10, -100))
c.containsSlice(Array(-10, -123))

//+= chain
c += 1 -= (-10)

//target.length==source.length
var target = Array(1, 2, 3, 4)
var source = Array(-1, -2, -3, -4)
source.copyToArray(target)
target

//target.length<source.length
target = Array(1, 2)
source.copyToArray(target)
target

//target.length>source
target = Array(1, 2, 3, 4)
source = Array(-1, -2)
source.copyToArray(target)
target

//using ++ to merge two collections to return another collection
Array(1, 2) ++ Array(3, 4)
ArrayBuffer(1, 2) ++ ArrayBuffer(3, 4)
//return ArrayBuffer
ArrayBuffer(1, 2) ++ Array(3, 4)
//return Array
Array(3, 4) ++ ArrayBuffer(1, 2)

Array(1, 2) ++ "Hello"
ArrayBuffer(1, 2) ++ "Hello"


Array(1, 2) ++: ArrayBuffer(3, 4)
Array(1, 2) ++: "Hello"
ArrayBuffer(1, 2) ++: "Hello"

//using ++: would align RIGHT operand with type of two operands are different
Array('a', 'b') ++: "cd"
ArrayBuffer('a', 'b') ++: "cd"

//using ++ would align LEFT operand with type of two operands are different
Array('a', 'b') ++ "cd"
ArrayBuffer('a', 'b') ++ "cd"