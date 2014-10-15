package hackerank.contest.functional

import scala.collection.mutable

/**
 * Created by abhinav on 10/9/14.
 */
object BangaloreBank {
  val memo: mutable.Map[String, Int] = new mutable.HashMap()
  def move(list: Array[Int], i: Int, left: Int, right: Int): Int = {
    memo.get(i + "_" + left + "_" + right) match {
      case Some(v) => v
      case None    =>
        val x = list{i}
        if (i == list.length - 1) {
          memo.put(i + "_" + left + "_" + right, Math.abs(getClosest(x, left, right) - x))
        } else {
          memo.put(i + "_" + left + "_" + right, Math.min(Math.abs(left - x) + move(list, i + 1, x, right), Math.abs(right - x) + move(list, i+ 1, left, x)))
        }
        memo.get(i + "_" + left + "_" + right).get
    }
  }

  def getClosest(x: Int, left: Int, right: Int): Int = {
    if (Math.abs(right - x) > Math.abs(left - x)) left else right
  }

  def minSteps(list: Array[Int]): Int = list match {
    case Array()  => 0
    case Array(x) => 0
    case arr if list.length == 2 => 0
    // case _ => move(list, 1, list{0}, list{0})
    case arr => List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).map { a => if (a == arr{1}) move(arr, 2, a, arr{0}) else move(arr, 1, a, arr{0}) }.foldLeft(Int.MaxValue) { case (a, b) => Math.min(a, b) }
  }

  def main(args: Array[String]) {
    val len = Console.readInt()
    val line = Console.readLine()
    println(len + minSteps(line.split(" ").map { s => if (s.toInt == 0) 10 else s.toInt }))
  }
}
