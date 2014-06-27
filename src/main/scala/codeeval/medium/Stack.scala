package codeeval.medium

import java.util.NoSuchElementException

/**
 * Created by abhinav on 18/6/14.
 */
object Stack extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val s = Stack("1 2 3 4".split(" ").map(s => s.toInt).toList.reverse)
    println(alternate(s, 0).mkString(" "))
  }

  def alternate(s: Stack, flag: Int): List[Int] = {
    if (s.isEmpty()) Nil
    else {
      (s, flag) match {
        case (s, 0) => val t = s.pop()
          t._1 :: alternate(t._2, 1)
        case (s, 1) => alternate(s.pop()._2, 0)
      }
    }
  }

  case class Stack(list: List[Int] = Nil) {
    def isEmpty(): Boolean = list == Nil
    def push(v: Int): Stack = {
      Stack(v :: list)
    }
    def pop(): (Int, Stack) = list match {
      case Nil => throw new NoSuchElementException("cannot pop from an empty list")
      case x :: xs => (x, Stack(xs))
    }
    override def toString(): String = {
      list.mkString(" ")
    }
  }
}


