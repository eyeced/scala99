package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object HappyNumbers extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    println(isHappy("".toInt, List()))
  // }

  def isHappy(n: Int, numbers: List[Int]): Int = n match {
    case 1 => 1
    case x => if (numbers.contains(x)) 0 else isHappy(next(x), x :: numbers)
  }

  def next(n: Int): Int = {
    n.toString.split("").map(x => if (!x.isEmpty) x.toInt * x.toInt else 0).foldLeft(0)(_ + _)
  }
}
