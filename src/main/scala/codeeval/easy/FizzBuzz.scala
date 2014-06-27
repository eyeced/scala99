package codeeval.easy

import scala.io.Source

/**
 * Created by abhinav on 11/6/14.
 */
object FizzBuzz {
  def main(args: Array[String]) {
    for(line <- Source.fromFile(args{0}).getLines()) {
      println(getFizzBuzz(line))
    }
  }

  def getFizzBuzz(line: String): String = {
    val input = line.split(" ").map(s => s.toInt)
    val range = 1 until (input{2} + 1)
    range.map(r =>
      if (r % input{0} == 0 || r % input{1} == 0) {
        if (r % input{0} == 0 && r % input{1} == 0) {
          "FB"
        } else if (r % input{0} == 0) {
          "F"
        } else {
          "B"
        }
      } else {
        r
      }
    ).mkString(" ")
  }
}
