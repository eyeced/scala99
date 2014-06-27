package codeeval.easy

/**
 * Created by abhinav on 11/6/14.
 */
object BitPosition extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val a = l.split(",").map(s => s.toInt)
    println(((a{0} >> (a{1} - 1)) & 1) == ((a{0} >> (a{2} - 1)) & 1))
  }
}
