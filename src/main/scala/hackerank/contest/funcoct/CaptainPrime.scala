package hackerank.contest.funcoct

/**
 * Created by abhinav on 13/10/14.
 */
object CaptainPrime {

//  def central(x: Int, primes: List[Int]): Boolean = {
//    true
//  }

  def place(x: Int): String = x match {
    case n if isPrime(x) && noZero(n) =>
      val pres = prefixes(n).map { a => isPrime(a) }.foldLeft(true)(_ & _)
      val sufs = suffixes(n).map { a => isPrime(a) }.foldLeft(true)(_ & _)
      (pres, sufs) match {
        case (true, true)  => "CENTRAL"
        case (true, false) => "LEFT"
        case (false, true) => "RIGHT"
        case _             => "DEAD"
      }
    case _ => "DEAD"
  }

  def prefixes(n: Int): List[Int] = {
    val s = n.toString
    (1 to (s.length - 1)).map { i => s.substring(i).toInt }.toList
  }

  def suffixes(n: Int): List[Int] = {
    val s = n.toString
    (1 to (s.length - 1)).map { i => s.substring(0, s.length - i).toInt }.toList
  }

  def isPrime(n: Int): Boolean = n match {
    case 1 => false
    case 2 => true
    case x =>
      val root = Math.pow(n, 0.5).toInt
      var x = 2
      while (x <= root) {
        if (n % x == 0) {
          return false
        }
        x += 1
      }
      true
  }

  def noZero(n: Int): Boolean = {
    n.toString.indexOf('0') < 0
  }

  def main(args: Array[String]) {
    println(place(137))
//    val tests = Console.readLine().toInt
//    (1 to tests).foreach { i =>
//      println(place(Console.readLine().toInt))
//    }
  }
}
