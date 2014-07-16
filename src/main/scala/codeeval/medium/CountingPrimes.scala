package codeeval.medium

/**
 * Created by abhinav on 15/7/14.
 */
object CountingPrimes extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = "20,30".split(",")
    println(numOfPrimes(arr{0}.toInt, arr{1}.toInt))
  }

  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  }

  def numOfPrimes(start: Int, end: Int): Int = {
    sieve(Stream.from(2)).takeWhile(_ <= end).length - sieve(Stream.from(2)).takeWhile(_ <= start - 1).length
  }
}
