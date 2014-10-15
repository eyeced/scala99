package hackerank.contest.functional

/**
 * Created by abhinav on 6/9/14.
 */
object StringCompression {
  def main(args: Array[String]) {
    val str = Console.readLine()
    println(compress(str.substring(1), str{0}, 1, new StringBuilder()))
  }

  def compress(list: Seq[Char], cur: Char, count: Int, acc: StringBuilder): String = list match {
    case Nil                         => if (count == 1) acc.append(cur).toString() else acc.append(cur).append(count).toString()
    case Seq(x, xs@_*) if (x == cur) => compress(xs, cur, count + 1, acc)
    case Seq(x, xs@_*)               => if (count == 1) compress(xs, x, 1, acc.append(cur)) else compress(xs, x, 1, acc.append(cur).append(count))
  }
}
