package codeeval.hard


/**
 * Created by abhinav on 28/6/14.
 */
object StringList extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = l.split(",")
    println(combinations(arr{1}.toList.distinct.sorted, arr{0}.toInt).mkString(","))
  }

  def combinations(chars: List[Char], len: Int): List[String] = len match {
    case 1 => chars.map(c => c.toString)
    case _ => for {
      c <- chars
      s <- combinations(chars, len - 1)
    } yield c + s
  }
}
