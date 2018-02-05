//create Regex object with .r
val numPattern = "[0-9]+".r

//create Regex object with raw string
val wsnumsPattner =
  """\s+[-9]+\s+""".r

//process matching result in for loop
for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles"))
  println(matchString)

//translate result into array
numPattern.findAllIn("99 bottles, 98 bottles").toArray

val Some(first) = numPattern.findFirstIn("99 bottles, 98 bottles")


val anchoredPattern = "^[0-9]+$".r
anchoredPattern.findFirstIn("123324322342")

//replace
numPattern.replaceFirstIn("99 bottles, 98 bottles", "300")

numPattern.replaceAllIn("99 bottles, 98 bottles", "300")

//replaceSome
numPattern.replaceSomeIn("15 bottles, 98 bottles",
  matching => if (matching.matched.toInt % 2 == 0) Some("even") else None
)

val varPattern ="""\$[0-9]+""".r
def format(msg: String, vars: String*) = {
  varPattern.replaceSomeIn(msg, m =>
    vars.lift(m.matched.tail.toInt)
  )
}

format("At $1, there was $2 on $0", "planet7", "12:30 pm", "a disturbance of the force")

//matcher group
val numitemPattern =
  """([0-9]+) ([a-z]+)""".r
for (m <- numitemPattern.findAllMatchIn("99 bo, 98 bottles"))
  println(m.group(1), m.group(2))

//extractor usage
val numitemPattern(num, item) = "123 abc"
for (numitemPattern(num, item) <- numitemPattern.findAllIn("99 bo, 98 bottles"))
  println((num, item))


