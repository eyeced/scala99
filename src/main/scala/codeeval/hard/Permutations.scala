package codeeval.hard

/**
 * Created by abhinav on 26/6/14.
 */
object Permutations extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(permutations(l).sorted.mkString(","))
  }

  def permutations(str: String): List[String] = {
    if (str.length == 1) List(str)
    else permutations(str.tail).map(p => combinations(str.head, p)).flatten
  }

  def combinations(ch: Char, str: String): List[String] = {
    (for {
      i <- 0 until (str.length + 1)
    } yield str.substring(0, i) + ch + str.substring(i, str.length)).toList
  }
}
