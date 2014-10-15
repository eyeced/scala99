package hackerank.contest.infinitum

/**
 * Created by abhinav on 20/9/14.
 */
object SumOfSquares {

  val sos = (1 to 320000).map { i => sumOfSquare(i.toDouble) }.toArray

  def sumOfSquare(n: Double): Double = {
    n * (n + 1) * (2 * n + 1) / 6
  }

  def find(n: Double, start: Int, end: Int): Int = {
    val mid = (start + end) / 2
    if (end - start == 1 || end == start) {
      if (n != sos{end}) start
      else end
    } else {
      if (n > sos{mid}) find(n, mid, end)
      else if (n < sos{mid}) find(n, start, mid)
      else mid
    }
  }

  def main(args: Array[String]) {
    val tests = Console.readInt()
    (1 to tests).foreach {
      i =>
        println(find(Console.readDouble(), 0, sos.length - 1) + 1)
    }
    println(sos.mkString(", "))
    println(find(1000000, 0, sos.length - 1) + 1)
    println((9000000 to 10000000).toStream.takeWhile { n => (n * (n + 1) * (2 * n + 1) / 6) < Math.pow(10, 16) }.last)
  }
}
