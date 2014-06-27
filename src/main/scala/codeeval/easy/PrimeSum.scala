package codeeval.easy

/**
 * Created by abhinav on 11/6/14.
 */
object PrimeSum extends App {

  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  }
  println(sieve(Stream.from(2)).take(1000).foldLeft(0)((r, c) => r + c))
}
