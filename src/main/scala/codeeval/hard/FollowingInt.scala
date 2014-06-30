package codeeval.hard

/**
 * Created by abhinav on 28/6/14.
 */
object FollowingInt extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
     println(nextInt(l))
  }

  def nextInt(s: String): String = {
    val numZero = s.filter(_ == '0')
    val nonZero = s.filter(_ != '0')
    if (inDescOrder(nonZero)) {
      // do this for numbers like 54321 so next would be 102345, similarly 8000's next would be 80000
      val num = nonZero.map(_.toString.toInt).sorted
      if (num.size > 1)
        num.head + ("0" * (numZero.length + 1)) + num.tail.mkString("")
      else
        num.head + ("0" * (numZero.length + 1))
    } else {
      // get all possible combinations for the string and sort them
      val sortedStr = s.sorted
      val combs = combinations(List(sortedStr.head.toString), sortedStr.substring(1, sortedStr.length).toList)
      val sortedC = combs.sorted
      println(sortedC)
      sortedC.drop(sortedC.indexOf(s) + 1).head
    }
  }

  def inDescOrder(s: String): Boolean = {
    if (s.length == 1) true
    else {
      (for {
        i <- 1 until s.length
        if s{i} > s{i - 1}
      } yield s{i}).length == 0
    }
  }

  def combinations(acc: List[String], chars: List[Char]): List[String] = chars match {
    case Nil => acc
    case c :: cs =>
      val newAcc = for {
        e <- acc
        i <- 0 until (e.length + 1)
      } yield {
        e.substring(0, i) + c + e.substring(i, e.length)
      }
      combinations(newAcc, cs)
  }
}
