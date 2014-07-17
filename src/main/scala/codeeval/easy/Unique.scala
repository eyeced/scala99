package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object Unique extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    "8,8,9,10,10,11,12,13,14,15,16".split(",").map(_.toInt).distinct.mkString(",")
  // }
}
