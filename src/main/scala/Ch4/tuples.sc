val t = (1, 3.14, "Fred")
t._1
t._2
t._3


//get components by pattern match
val (first, second, third) = t
first
second
third

//use _ if you do not need
val (_, _, a) = t
a
"New York".partition(_.isUpper)

//zipping, could be used to process value
val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)
for ((s, n) <- pairs) println(s * n)

//pair -> map
pairs.toMap