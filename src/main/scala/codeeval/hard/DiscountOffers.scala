package codeeval.hard

/**
 * Created by abhinav on 30/6/14.
 */
object DiscountOffers extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {

  }

  def maxScore(products: List[String], names: List[String]): Double = {
    0.0
  }

  def scalabilityScore(product: String, name: String): Double = {
    val ss = evenScore(product, name) + oddScore(product, name)
    if (haveCommonFactors(letters(product).length, letters(name).length))
      ss * 1.5
    else
      ss
  }

  def letters(s: String): String = {
    s.filter(c => (c.toInt > 64 && c.toInt < 91) || (c.toInt > 96 && c.toInt < 123))
  }

  def evenScore(product: String, name: String): Double = {
    if (letters(product).length % 2 == 0)
      name.filter(c => List('a', 'e', 'i', 'o', 'u').contains(c)).length * 1.5
    else
      0.0
  }

  def oddScore(product: String, name: String): Double = {
    if (letters(product).length % 2 == 1)
      name.filter(c => !List('a', 'e', 'i', 'o', 'u').contains(c)).length
    else
      0.0
  }

  def haveCommonFactors(x: Int, y: Int): Boolean = {
    (for {
      i <- 2 until Math.min(Math.pow(x, 0.5), Math.pow(y, 0.5)).toInt + 1
      if (x % i == 0 && y % i == 0)
    } yield i).length > 0
  }
}
