package hackerank.contest.funcOct

/**
 * Created by abhinav on 11/10/14.
 */
object PrefixCompression {
  def break(str1: String, str2: String): List[String] = {
    var i = 0
    val buf = new StringBuilder
    while (i < str1.length && i < str2.length && str1{i} == str2{i}) {
      buf.append(str1{i})
      i += 1
    }
    List(buf.toString(), str1.substring(i), str2.substring(i))
  }

  def main(args: Array[String]) {
    val str1 = Console.readLine()
    val str2 = Console.readLine()
    println(break(str1, str2).map { s => s.length + " " + s}.mkString("\n"))
  }
}
