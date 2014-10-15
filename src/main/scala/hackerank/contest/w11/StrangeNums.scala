package hackerank.contest.w11

import scala.collection.mutable

/**
 * Created by abhinav on 8/10/14.
 */
object StrangeNums {

  def strange(): List[Int] = {
    var set = mutable.HashSet[Int]()
    var queue = mutable.Queue[Int]()

    queue ++= List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    var e = 0
    val max = Math.pow(10, 9)
    while (e < max) {
      e = queue.dequeue()
      set += e
      val foo = e.toString.length
      var i = foo
      while (foo <= (e * i).toString.length && i < 10) {
        if ((e * i).toString.length == i) {
          queue.enqueue(e * i)
          i += 1
        }
      }
    }
    set.toList
  }

  def main(args: Array[String]) {
    println(strange().mkString(" "))
  }

}
