package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object SumIntegers extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  var sum = 0
  for (l <- lines) {
    sum += l.toInt
  }
  println(sum)
}
