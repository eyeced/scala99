package codeeval.easy

/**
 * Created by abhinav on 11/6/14.
 */
object ReverseWords extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(reverseWords(l))
  }

  def reverseWords(s: String): String = {
    s.split(" ").reverse.mkString(" ")
  }
}
