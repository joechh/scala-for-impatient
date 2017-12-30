val array = Array(1, 2, 3, 4, 5, 6)
//work
for (i <- 0 until array.length) println(s"[$i]: ${array(i)}")

//does not work
for (i <- 0 until array.length by -1) println(s"[$i]: ${array(i)}")

//more concise
for (i <- array.indices) println(s"[$i]: ${array(i)}")

//more concise
for (i <- array.indices.reverse) println(s"[$i]: ${array(i)}")

//if not need array index, like foreach loop in Java
for(element<-array)
  print(s"$element ")