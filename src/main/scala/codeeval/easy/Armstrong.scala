package codeeval.easy

import codeeval.easy.Modulo._

/**
 * Created by abhinav on 17/7/14.
 */
object Armstrong extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(isArmstrong(l))
  }

  def isArmstrong(str: String): String = {
    if (str.split("").map(s => Math.pow(s.toInt, str.length).toInt).foldLeft(0)(_ + _) == str.toInt) "True" else "False"
  }

}
