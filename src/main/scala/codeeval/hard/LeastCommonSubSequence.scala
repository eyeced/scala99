package codeeval.hard

/**
 * Created by abhinav on 25/6/14.
 */
object LeastCommonSubSequence extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val strArr = l.split(";")
    println(lcs(strArr{1}, strArr{0}))
  }

  def lcs(s1: String, s2: String): String = {
    val matrix = Array.ofDim[String](s1.length + 1, s2.length + 1)

    for {
      i <- 0 until (s1.length + 1)
      j <- 0 until (s2.length + 1)
    } yield {
      if (i == 0 || j == 0) matrix{i}{j} = ""
      else if (s1{i - 1} == s2{j - 1}) matrix{i}{j} = matrix{i - 1}{j - 1} + s1{i - 1}
      else {
        val seq1 = matrix{i}{j - 1}
        val seq2 = matrix{i - 1}{j}
        matrix{i}{j} = if (seq1.length > seq2.length) seq1 else seq2
      }
    }
    matrix{s1.length}{s2.length}
  }
}
