package codeeval.medium

/**
 * Created by abhinav on 18/6/14.
 */
object Stack extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    l.split(" ").map(s => s.toInt).toList
  }

  case class Stack(list: List[Int] = Nil) {
    def push(a: Int): Stack = {
       Stack(a :: list)
    }

    def pop(): (Int, Stack) = {
      list match {
        case x :: xs => (x, Stack(xs))
      }
    }
  }
}
