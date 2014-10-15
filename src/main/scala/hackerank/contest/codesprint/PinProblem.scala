package hackerank.contest.codesprint

import scala.util.control.Breaks._

/**
 * Created by abhinav on 17/9/14.
 */
object PinProblem {

  val primes = sieve(Stream.from(2)).takeWhile(_ < 10000).toArray

  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  }

  def primeFactors(n: Int): List[Int] = n match {
    case 1 => List(1)
    case _ =>
      var i = 0
      breakable {
        while (primes{i} < n) {
          if (n % primes{i} == 0) break
          i += 1
        }
      }
      primes{i} :: primeFactors(n / primes{i})
  }

  def pins(mArr: Array[Int], n: Int): Int = {
    val lcm = mArr.map { x => primeFactors(x) }.foldLeft(List(1)) { (x, y) => x.union(y).diff(x.intersect(y)) }.foldLeft(1)(_ * _)
    (n / lcm)
  }

  def main(args: Array[String]) {
    val tests = Console.readInt()

    (1 to tests).foreach { x =>
      val arr = Console.readLine().split(" ").map(_.toInt)
      val n = arr{0}
      val mArr = Console.readLine().split(" ").map(_.toInt)
      println(pins(mArr, n))
    }
  }
}
