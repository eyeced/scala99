package codeeval.easy

/**
 * Created by abhinav on 11/6/14.
 */
object Fib extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    if (!l.trim.isEmpty) println(fib(l.toInt))
  }

  def fib(n: Int): Int = {
    def fib_tail(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => fib_tail(n - 1, b, a + b)
    }
    fib_tail(n, 0, 1)
  }
}
