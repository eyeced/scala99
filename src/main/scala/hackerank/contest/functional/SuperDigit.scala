package hackerank.contest.functional

/**
 * Created by abhinav on 6/9/14.
 */
object SuperDigit {

  def main(args: Array[String]) {
    val str = Console.readLine()
    val a = str.split(" ")
    println(digit(a{0}, a{1}.toInt))
  }

  def digit(s: String, k: Int): Int = {
    val sum = s.foldLeft(0){ (x, y) => x + y.toString.toInt }
    if (sum < 10) {
      if (k > 1) digit((sum * k).toString, 1) else sum
    } else digit(sum.toString, 1)
  }
}
