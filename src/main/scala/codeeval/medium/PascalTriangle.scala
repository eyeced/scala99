package codeeval.medium

/**
 * Created by abhinav on 15/7/14.
 */
object PascalTriangle extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(pascal(l.toInt))
  }

  def pascal(n: Int): String = {
    (1 until n).foldLeft(List("1"))((a, b) => a ::: List(row(a.last))).mkString(" ")
  }

  def row(prev: String): String = prev match {
    case "1" => "1 1"
    case _   => "1 " + sumAlt(prev) + " 1"
  }

  def sumAlt(s: String): String = {
    val arr = s.split(" ")
    (for {
      i <- 1 until arr.length
    } yield arr{i}.toInt + arr{i - 1}.toInt).mkString(" ")
  }

}
