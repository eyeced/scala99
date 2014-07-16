package codeeval.medium

/**
 * Created by abhinav on 16/7/14.
 */
object ValidParentheses extends App {

  val brackets = Map((')', '('), (']', '['), ('}', '{'))

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
      println(isValid(l, List()))
  }

  def isValid(str: String, stack: List[Char]): String = (str, stack) match {
    case ("", Nil)   => "True"
    case ("", xs)    => "False"
    case (s, Nil)     =>
      brackets.get(s.head) match {
        case Some(v) => "False"
        case None    => isValid(s.tail, List(s.head))
      }
    case (s, x :: xs) =>
      brackets.get(s.head) match {
        case Some(v) => if (v == x) isValid(s.tail, xs) else "False"
        case None    => isValid(s.tail, s.head :: stack)
      }
  }
}
