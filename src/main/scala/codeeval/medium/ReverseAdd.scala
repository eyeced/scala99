package codeeval.medium

/**
 * Created by abhinav on 15/7/14.
 */
object ReverseAdd extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val tup = reverseAndAdd("195".toInt, 0)
    println(tup._2 + " " + tup._1)
  // }

  def isPalindrome(n: String): Boolean = n.length match {
    case 1 => true
    case 2 => n.head == n.last
    case _ => if (n.head == n.last) isPalindrome(n.substring(1, n.length - 1)) else false
  }

  def reverseAndAdd(n: Int, itr: Int): (Int, Int) = {
    if (itr == 100) (n, 100)
    else if (isPalindrome(n.toString)) (n, itr)
    else {
      val eric = n + n.toString.reverse.toInt
      reverseAndAdd(eric, itr + 1)
    }
  }

}
