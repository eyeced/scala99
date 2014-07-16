package codeeval.medium

/**
 * Created by abhinav on 16/7/14.
 */
object DecodeNumbers extends App {

  val arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    println(decode("12".split("").toList))
  // }

  def decode(list: List[String]): Int = list match {
    case Nil      => 0
    case x :: Nil => 1
    case x :: xs  =>
      println(x + xs.head)
      val num = if ((x + xs.head).toInt < 27) decode(xs.tail) else 0
      decode(xs) + num
  }

}
