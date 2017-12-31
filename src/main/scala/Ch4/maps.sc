//default immutable map
val scores = Map("Alice" -> 5, "Alice" -> 3, "Alice" -> 20, "Bob" -> 25)
scores("Alice")

//mutable map
val mutableMap = scala.collection.mutable.Map("Alice" -> 5, "Bob" -> 3)


//empty mutable map, should define key and value types
val emptyMap = scala.collection.mutable.Map[String, Int]()

scores("Bob")
//scores("unknown") throws NoSuchElementException
scores.getOrElse("unknown", -1)

//get function return Option result
scores.get("unknown")

//immutable has other functions to deal with unknown-key
val scores1 = scores.withDefaultValue(-100)
scores1("haha")
scores1.get("haha")
val scores2 = scores.withDefault(_.length)
scores2("what are you doing")
val length = scores2.get("what are you doing");