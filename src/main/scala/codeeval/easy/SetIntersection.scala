package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object SetIntersection extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = l.split(";")
    val a1 = arr{0}.split(",")
    val a2 = arr{1}.split(",")
    println(a1.filter(a => a2.contains(a)).mkString(","))
  }

}
