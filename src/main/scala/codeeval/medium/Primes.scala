package codeeval.medium

/**
 * Created by abhinav on 15/7/14.
 */
object Primes extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    println(sieve(Stream.from(2)).takeWhile(_ < "200".toInt).mkString(","))
  // }

  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  }
}
