package codeeval.hard

/**
 * Created by abhinav on 8/7/14.
 */
object StringSub extends App {
  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val arr = "10100101101110011000;10,111,00,10,010,00".split(";")
    println(sub(arr{1}.split(",").toList, List((true, arr{0}))))
  // }

  def sub(list: List[String], subs: List[(Boolean, String)]): String = list match {
    case Nil      => subs.map(_._2).mkString("")
    case x :: xs  => sub(xs.tail, subs.map(y => if(y._1) splitAndAdd(y._2, x, xs.head) else List(y)).flatten)
  }

  def splitAndAdd(str: String, pattern: String, replace: String): List[(Boolean, String)] = {
    if (str.contains(pattern))
      str.split(pattern).toList match {
        case Nil      => List((true, replace))
        case s :: Nil => if (str.indexOf(pattern) > 0) List((true, s), (false, replace)) else List((false, replace), (true, s))
        case list     => concatInBetween(list, replace, Nil)
      }
    else
      List((true, str))
  }

  def concatInBetween(list: List[String], s: String, acc: List[(Boolean, String)]): List[(Boolean, String)] = list match {
    case Nil      => acc
    case x :: Nil => acc ::: List((true, x))
    case x :: xs  => concatInBetween(xs, s, acc ::: List((true, x), (false, s)))
  }
}
