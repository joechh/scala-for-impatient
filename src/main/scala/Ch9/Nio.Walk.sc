import java.nio.file.{Files, Paths}

//Visiting Directory
val dirname = "/home/joechh/Scala"
val entries = Files.walk(Paths.get(dirname))
try{
  entries.forEach(p=>println(p.getFileName))
}finally {
  entries.close()
}