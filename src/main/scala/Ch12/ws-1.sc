//12.1
val num = 3.14
val floorFun: Double => Double = math.floor _
// _ could be ignored when function is expected
val ceilFun = math.ceil _
ceilFun(2.5)
val f: (String, Int) => Char = _.charAt(_)
floorFun(num)
Array(3.14, 1.42, 2.1).map(floorFun)

//12.2 Anonymous Function
(x: Double) => x * 3

//assign to val
val triple = (x: Double) => x * 3

//just like you had used a def:
def tripleFun(x: Double) = x * 3

//using anonymous fun in map
Array(3.14, 1.42, 2.1).map((x: Double) => x * 3)

//using enclose  in braces instead of parentheses
Array(3.14, 1.42, 2.1).map { (x: Double) => x * 3 }
Array(3.14, 1.42, 2.1) map { (x: Double) => x * 3 }

//12.3 function with function parameters (high-order function)
def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
valueAtOneQuarter(math.ceil(_))
valueAtOneQuarter(math.ceil)
valueAtOneQuarter(math.sqrt(_))

def mulBy(factor: Double) = (x: Double) => x * factor
val fourTimes = mulBy(4)
fourTimes(100)

//12.4 Parameter Inference
valueAtOneQuarter((x: Double) => x * 3)
valueAtOneQuarter((x) => x * 3)
valueAtOneQuarter(x => x * 3)
valueAtOneQuarter(_ * 3)
(_: String).length
(_: String).substring(_: Int, _: Int)

//12.5 Useful high-order function
(1 to 9).map(_ * 0.1)
(1 to 9).map("*" * _).foreach(println)
(1 to 9).filter(_ % 2 == 0)
(1 to 9).reduceLeft(_ * _)
"This is a test".split(" ").sortWith(_.length < _.length)

