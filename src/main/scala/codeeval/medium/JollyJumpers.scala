package codeeval.medium

/**
 * Created by abhinav on 7/7/14.
 */
object JollyJumpers extends App {
  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
     if (isJolly("1 4 2 3".split(" ").map(_.toInt))) println("Jolly") else println("Not jolly")
  // }

  def isJolly(arr: Array[Int]): Boolean = {
    ((for { i <- (1 until arr.length) } yield Math.abs(arr{i} - arr{i - 1})).foldLeft(0)(_ ^ _) ^ (1 until arr.length).foldLeft(0)(_ ^ _)) == 0
  }
}
