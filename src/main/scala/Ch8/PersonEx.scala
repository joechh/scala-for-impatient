package Ch8

class PersonEx(val name: String) {
  override def toString: String = s"${getClass.getName}[name=$name]"
}

class SecretAgentEX(codename: String) extends PersonEx(codename) {

  override val name: String = "secret"
  override val toString: String = "secret"
}
