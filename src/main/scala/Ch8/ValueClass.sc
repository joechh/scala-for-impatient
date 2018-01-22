class MilTime(val time: Int) extends AnyVal {
  def minutes = time % 100

  def hours = time / 100

  override def toString = s"MilTime()"
}

val lunch = new MilTime(1230)
lunch.hours
lunch.minutes
