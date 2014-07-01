package codeeval.hard

/**
 * Created by abhinav on 29/6/14.
 */
object PalindromeRange extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = l.split(" ").map(_.toInt)
    println(interestingRanges(arr{0}, arr{1}))
  }

  def interestingRanges(l: Int, r: Int): Int = {
    val ranges = subRanges(l, r)
    ranges.filter(x => hasEvenPalindromes(x._1, x._2)).size
  }

  def hasEvenPalindromes(l: Int, r: Int): Boolean = {
    (l until r + 1).filter(isPalindrome(_)).size % 2 == 0
  }

  def subRanges(l: Int, r: Int): List[(Int, Int)] = {
    (for {
      i <- l until r + 1
      j <- i until r + 1
    } yield (i, j)).toList
  }

  def isPalindrome(n: Int): Boolean = n match {
    case x if n >=0 && n < 10 => true
    case x if n > 9 && n < 100 => x / 10 == x % 10
    case x => {
      val s = x.toString
      if (s{0} == s{s.length - 1}) isPalindrome(s.substring(1, s.length - 1).toInt)
      else false
    }
  }
}
