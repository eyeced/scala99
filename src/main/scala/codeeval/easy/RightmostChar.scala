package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object RightmostChar extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = l.split(",")
    println(arr{0}.lastIndexOf(arr{1}))
  }

}
