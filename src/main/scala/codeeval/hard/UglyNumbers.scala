package codeeval.hard

/**
 * Created by abhinav on 28/6/14.
 */
object UglyNumbers extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(uglyNumbers(l))
  }

  def uglyNumbers(str: String): Long = {
    expressionsTailRec(List(), str.toList.map(_.toString), List("", "+", "-")).map(computeExpr(_)).filter(isUgly(_)).length
  }

  def isUgly(n: Long): Boolean = {
    n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0
  }

  def computeExpr(expr: String): Long = {
    val x = expr.indexOf("+")
    val y = expr.indexOf("-")
    expr match {
      case e if (x < 0 && y < 0)                     => e.toLong
      case e if x > 0 && ((y > 0 && x < y) || y < 0) => e.substring(0, x).toLong + computeExpr(e.substring(x + 1, e.length))
      case e if ((x > 0 && x > y) || x < 0) && y > 0 => e.substring(0, y).toLong - computeExpr(e.substring(y + 1, e.length))
    }
  }

  def expressions(numbers: List[Char], operators: List[Char]): List[String] = numbers match {
    case x :: Nil => List(x.toString)
    case x :: xs  => for {
      o <- operators
      e <- expressions(xs, operators)
    } yield if (o.toString.trim.isEmpty) x.toString + e else x.toString + o.toString + e
  }

  def expressionsTailRec(acc: List[String], numbers: List[String], operators: List[String]): List[String] = numbers match {
    case Nil      => acc
    case x :: xs  => if (acc.isEmpty) expressionsTailRec(List(x), xs, operators)
      else {
        val newAcc = for {
          o <- operators
          e <- acc
        } yield if (o.isEmpty) e + x else e + o + x
        expressionsTailRec(newAcc, xs, operators)
      }
  }
}