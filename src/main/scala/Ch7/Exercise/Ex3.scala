import scala.util.Random

package object random {
  var seeds = Random.nextInt();
  val a = 1664525
  val b = 1013904223

  def setSeeds(seeds: Int) = this.seeds = seeds

  def nextInt(): Int = {
    val next = (seeds * a + b) % (math.pow(2, 32)).toInt
    this.seeds = next
    next
  }

  def nextDouble(): Double = {
    val next = (seeds * a + b) % (math.pow(2, 32))
    this.seeds = next.toInt
    next
  }
}

object Dev {
  def main(args: Array[String]): Unit = {
    println(random.nextInt())
    println(random.nextInt())

  }
}
