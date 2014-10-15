package hackerank.contest.codesprint

/**
 * Created by abhinav on 17/9/14.
 */
object LexiRotation {

  def maxChar(str: String): Char = {
    str.foldLeft(0) { (x, y) => Math.max(x, y) }.toChar
  }
  
  def indexesOfChar(str: String, from: Int, ch: Char): List[Int] = str.indexOf(ch, from) match {
    case -1 => Nil
    case x  => x :: indexesOfChar(str, x + 1, ch)
  }

  def lex(str: String, indexes: List[Int]): String = {
    if (indexes.length == str.length) str
    else indexes.map { x => str.substring(x, str.length) + str.substring(0, x) }.sorted.last
  }

  def main(args: Array[String]) {
    val t = Console.readInt()
    (1 to t).foreach { i =>
      val str = Console.readLine()
      println(lex(str, indexesOfChar(str, 0, maxChar(str))))
    }
  }
}
