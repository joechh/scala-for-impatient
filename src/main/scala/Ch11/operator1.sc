import scala.collection.mutable

//11.1
val `val` = 10
print(`val`)

//11.2 Infix operator
1 to 5
1.to(5)
1 -> 6
1.->(6)

// Unary operator
// postfix: unary operator follows its argument
42 toString;
42.toString;

//11.6 Associativity
// left-associative: operators that end in a colon(:)
1 :: 2 :: Nil //equal to 1 :: (2 :: Nil)
2 :: Nil //equal to Nil.::(2)

//11.7 Apply and Update methods
val score = new mutable.HashMap[String, Int]
score("Joe") = 100 //calls score.update("Joe",100)
val joeScore = score("Joe") //calls score.apply("Joe")

