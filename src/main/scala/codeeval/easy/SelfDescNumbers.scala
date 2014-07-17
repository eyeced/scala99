package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object SelfDescNumbers extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(isSelfDescribing(0, "2020"))
  }

  def isSelfDescribing(i: Int, s: String): Int = {
    if (s.length == i) 1
    else if (s{i}.toString.toInt == s.filter(c => c.toString.toInt == i).length) isSelfDescribing(i + 1, s)
    else 0
  }

}
