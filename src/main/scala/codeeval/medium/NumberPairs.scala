package codeeval.medium

/**
 * Created by abhinav on 29/6/14.
 */
object NumberPairs extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val arr = "2,4,5,6,9,11,15;20".split(";")
    val numbers = arr{0}.split(",").map(_.toInt)
    val sum = arr{1}.toInt
    val p = pairs(numbers, sum)
    if (p.isEmpty) println("NULL") else println(p.mkString(";"))
  }

  def pairs(arr: Array[Int], n: Int): IndexedSeq[String] = {
    val gogo = arr.filter(_ < n)
    for {
      i <- 0 until gogo.length
      j <- i until gogo.length
      if (gogo{i} + gogo{j} == n)
    } yield gogo{i} + "," + gogo{j}
  }
}
