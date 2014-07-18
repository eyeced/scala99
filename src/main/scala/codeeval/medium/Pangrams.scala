package codeeval.medium

/**
 * Created by abhinav on 7/7/14.
 */
object Pangrams extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val p = pangram("A slow yellow fox crawls under the proactive dog")
    if (p.isEmpty) println("NULL") else println(p)
  }

  def pangram(s: String): String = {
    val arr = new scala.Array[Int](26)
    s.filter(c => c.toLower.toInt > 96 && c.toLower.toInt < 123).foreach(c => arr{c.toLower.toInt - 97} = 1)
    arr.zipWithIndex.filter{case (x, i) => x != 1}.map{ case (x, i) => (97 + i).toChar }.mkString("")
  }
}
