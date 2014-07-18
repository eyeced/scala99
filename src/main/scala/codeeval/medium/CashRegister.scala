package codeeval.medium

/**
 * Created by abhinav on 15/7/14.
 */
object CashRegister extends App {

  val bills = List(
    ("PENNY", 1),
    ("NICKLE", 5),
    ("DIME", 10),
    ("QUARTER", 25),
    ("HALF DOLLAR", 50),
    ("ONE", 100),
    ("TWO", 200),
    ("FIVE", 500),
    ("TEN", 1000),
    ("TWENTY", 2000),
    ("FIFTY", 5000),
    ("ONE HUNDRED", 10000)
  ).reverse

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val arr = "55;50".split(";")
    println(getBills(arr{0}.toDouble, arr{1}.toDouble).mkString(","))
  // }

  def getBills(pp: Double, ch: Double): List[String] = {
    if (pp > ch) List("ERROR")
    else if (pp == ch) List("ZERO")
    else combination(((ch - pp) * 100).toInt, List())
  }

  def combination(d: Int, acc: List[String]): List[String] = d match {
    case 0 => acc
    case _   =>
      val tup = bills.filter(_._2 <= d).head
      combination(d - tup._2, acc ::: List(tup._1))
  }
}
