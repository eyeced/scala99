package codeeval.medium

/**
 * Created by abhinav on 23/6/14.
 */
object NonRepeated extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(firstNonRepeated(l.head, l.tail))
  }

  def firstNonRepeated(c: Char, str: String): String = {
    if (str.contains(c)) {
      val newStr = str.replaceAll(c.toString, "")
      firstNonRepeated(newStr.head, newStr.tail)
    } else c.toString
  }
}
