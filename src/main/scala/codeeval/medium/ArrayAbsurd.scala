package codeeval.medium

/**
 * Created by abhinav on 7/7/14.
 */
object ArrayAbsurd extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = "20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14".split(";")
    println(absurd(arr{1}.split(",").map(_.toInt), arr{0}.toInt))
  }

  def absurd(arr: Array[Int], n: Int): Int = {
    (1 until n - 1).foldLeft(0)(_ ^ _) ^ arr.foldLeft(0)(_ ^ _)
  }
}
