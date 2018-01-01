package Ch5

import scala.beans.BeanProperty

class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {

}

object Dev {
  def main(args: Array[String]): Unit = {
    val student = new Student("Joe", 1)
    println(s"name:${student.getName}, id:${student.getId}")
  }
}
