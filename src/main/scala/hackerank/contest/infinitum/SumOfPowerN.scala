package hackerank.contest.infinitum

/**
 * Created by abhinav on 20/9/14.
 */
object SumOfPowerN {

  def lastTwoDigit(n: Int, pow: Int): Int = n match {
    case x if (n - 1 % 10 == 0) => lastTwo(((((n - 1) / 10) * (pow % 10)).toString + "1"))
    case x if (n - 2 % 10 == 0) =>
      val foo = pow / 10
      val bar = pow % 10
      val two = foo match {
        case even if (foo % 2 == 0) => 76
        case odd                    => 24
      }
      two

  }

  def lastTwo(s: String): Int = {
    s.substring(s.length - 1, s.length).toInt
  }

}
