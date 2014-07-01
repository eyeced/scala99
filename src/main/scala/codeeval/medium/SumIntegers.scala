package codeeval.medium

/**
 * Created by abhinav on 29/6/14.
 */
object SumIntegers extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val list = "-1,-2,-3,-1,0,-4,-5".split(",").map(_.trim.toInt).toList
    if (list.filter(_ > 0).length == 0) println(getMax(list.tail, list.head))
    else println(maxSum(list, 0, 0))
  // }

  def maxSum(list: List[Int], sum: Int, max: Int): Int = list match {
    case x :: Nil => if (x < 0) max else Math.max(x + sum, max)
    case x :: xs  =>
      if (x < 0) {
        val newSum = sum + x
        if (newSum < 0) maxSum(xs, 0, max)
        else maxSum(xs, newSum, max)
      } else {
        maxSum(xs, sum + x, Math.max(sum + x, max))
      }
  }

  def getMax(list: List[Int], max: Int): Int = list match {
    case x :: Nil => if (x > max) x else max
    case x :: xs  => getMax(xs, Math.max(x, max))
  }
}
