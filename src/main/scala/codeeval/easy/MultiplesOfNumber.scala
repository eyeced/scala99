package codeeval.easy

/**
 * Created by abhinav on 11/6/14.
 */
object MultiplesOfNumber extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val nums = l.split(",").map(s => s.toInt)
    if (nums{0} % nums{1} == 0) println(nums{0})
    else println(((Math.floor(nums{0} / nums{1}) + 1) * nums{1}).toInt)
  }
}
