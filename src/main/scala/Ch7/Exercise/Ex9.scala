package Ch7.Exercise

import java.lang.System._

object Ex9 {
  def main(args: Array[String]): Unit = {
    val user = getProperty("user.name")
    val password = readLine("give the password:")
    if (!password.equals("secret"))
      err.println(s"user:$user, password:$password")
    else
      println(s"Welcome! $user")
  }
}
