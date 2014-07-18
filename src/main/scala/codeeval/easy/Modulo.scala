package codeeval.easy

/**
 * Created by abhinav on 17/7/14.
 */
object Modulo extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = l.split(",").map(_.toInt)
     println(mod(arr{0}, arr{1}))
  }

  def mod(x: Int, y: Int): Int = {
    x - (x / y) * y
  }
}
