package codeeval.medium

/**
 * Created by abhinav on 23/6/14.
 */
object EndsWith extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = l.split(",")
    if (arr{0}.endsWith(arr{1})) println(1) else println(0)
  }
}
