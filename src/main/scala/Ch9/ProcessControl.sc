import java.io.File

import scala.sys.process._

//return 0 if execute successfully
val res = "ls -al /home/joechh".!
println(res)

//return result as a string
var resStr = "ls -al /home/joechh".!!

//pipeline
("ls -al /home/joechh" #| "grep Scala").!

//redirect to file
("ls -al /home/joechh" #> new File("/home/joechh/test")).!


("echo test" #>> new File("/home/joechh/test")).!
