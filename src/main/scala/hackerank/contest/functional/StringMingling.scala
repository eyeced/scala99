package hackerank.contest.functional

/**
 * Created by abhinav on 6/9/14.
 */
object StringMingling {

  def main (args: Array[String]) {
    val str1 = Console.readLine()
    val str2 = Console.readLine()
    println(mingle(str1, str2))
  }

  def mingle(s1: String, s2: String): String = {
    val s2_a = s2.split("")
    s1.split("").zipWithIndex.map { case (s, i) => s + s2_a{i} }.mkString("")
  }
}
