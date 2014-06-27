package codeeval.easy

/**
 * Created by abhinav on 11/6/14.
 */
object PalindromePrime extends App {
  val range = 2 until 1000

  def sieve(s: List[Int]): List[Int] = s match {
    case Nil => s
    case _ => s.head :: sieve(s.tail.filter(_ % s.head != 0))
  }

  def isPalindrome[A](list: List[A]): Boolean = {
    if (list.size % 2 == 0) false
    else if (list.size == 1) true
    else if (list.head == list.last) isPalindrome(list.tail.dropRight(1))
    else false
  }

  val primes = sieve(range.toList)
  val palindromes = primes.filter(p => isPalindrome(p.toString().split("").toList))
  println(palindromes.last)
}
