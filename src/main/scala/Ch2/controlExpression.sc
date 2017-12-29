val x = 2
// conditional expression has a value (ex: 1 or -1)
val s = if (x > 1) 1 else -1 //

//every expression has a type (ex:Int )
if (x > 1) 1 else -1

if (x > 1) 1 //which is equal the following equation
if (x > 1) 1 else Unit

//Input/Output
print("Answer: ")
println("42")
println("Answer" + 42)
val name = "Joe"
val age = 33
//C-style format string
printf("Hwllo, %s! Your are %d yeas old.%n", "Joe", 33)

//Better, use f-format interpolation(type safe via %s,%f symbols)
println(f"Hello, $name%s! You are ${age + 1.03}%7.2f year old after an year goes by %n")

//escape would not be evaluated
println(raw"\n is newline")

//String interpolator
println(s"Hello, $name")
println(s"1 + 1 = ${1 + 1}")
println(s"Hello, $$name")
def decorate(str: String, left: String = "[", right: String = "]") = left + str + right




