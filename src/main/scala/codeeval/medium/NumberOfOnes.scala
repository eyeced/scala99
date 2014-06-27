package codeeval.medium

/**
 * Created by abhinav on 23/6/14.
 */
object NumberOfOnes extends App {
  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    println(binary("4".toInt))
  // }

  def numberOfOnes(x: Int): Int = x match {
    case 1 => 1
    case _ => if (x % 2 == 0) numberOfOnes(x / 2) else 1 + numberOfOnes(x / 2)
  }

  def binary(n: Int): String = n match {
    case 1 => "1"
    case _ => if (n % 2 == 0) binary(n / 2) + "0" else binary(n / 2) + "1"
  }
}
