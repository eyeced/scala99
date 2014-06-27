package codeeval.hard

/**
 * Created by abhinav on 26/6/14.
 */
object Prefix extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(evaluate(l.split(" ").toList).head)
  }

  def evaluate(list: List[String]): List[String] = list match {
    case x :: Nil => list
    case x :: xs =>
      if (isOperand(x)) {
        val l: List[String] = evaluate(xs)
        x match {
          case "*" => compute(l, {(a, b) => a * b})
          case "/" => compute(l, {(a, b) => a / b})
          case "+" => compute(l, {(a, b) => a + b})
        }
      } else {
        if (isOperand(xs.head)) x :: evaluate(xs)
        else list
      }
  }

  def compute(list: List[String], fn: (Int, Int) => Int): List[String] = {
    fn(list.head.toInt, list.tail.head.toInt).toString :: list.tail.tail
  }

  def isOperand(s: String): Boolean = s match {
    case "*" | "/" | "+" => true
    case _ => false
  }
}
