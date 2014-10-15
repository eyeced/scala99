package hackerank.contest.functional

import scala.collection.mutable

/**
 * Created by abhinav on 13/9/14.
 */
object ApeWar1 {

  val map = new scala.collection.mutable.HashMap[String, Int]()

  def main(args: Array[String]) {

    val line1Arr = Console.readLine().split(" ").map(_.toInt)
    val n = line1Arr{0}
    val m = line1Arr{1}
    val s = System.currentTimeMillis()

    val arr = Console.readLine().split(" ").map(_.toInt)
    val rank = new Array[Int](n)

    def getRank(i: Int, count: Int): Int = arr{i - 2} match {
      case 1 => 1 + count
      case x => if (rank{x - 1} > 0) count + 1 + rank{x - 1} else getRank(x, count + 1)
    }
    (1 to arr.length).par.foreach { x =>
      rank{x} = getRank(x + 1, 0)
    }

    val k = System.currentTimeMillis()

    val buf = new scala.collection.mutable.ArrayBuilder.ofRef[String]()

    (1 to m).foreach{ x =>
      buf += Console.readLine()
    }
    val input = buf.result()
    val result = new Array[Int](m)
    (0 to m - 1).par.foreach { i =>
      result{i} = process(arr, rank, input{i})
    }
    println(result.mkString("\n"))
    val e = System.currentTimeMillis()
    //println(buf.result().map { s => process(arr, rank, s) }.mkString("\n"))

    println(k - s)
    println(e - s)
  }

  def process(arr: Array[Int], rank: Array[Int], message: String): Int = {
    val a = message.split(" ").map(_.toInt)
    val start = a{0}
    val end = a{1}
    val range = a{2} to a{3}

    def numHumans(start: Int, end: Int, countStart: Int, countEnd: Int): Int = {
      if (start == end) {
        if (range.contains(start)) countStart + 1 + countEnd else countStart + countEnd
      } else {
        if (rank{start - 1} > rank{end - 1})      numHumans(arr{start - 2}, end, countStart + humanCount(start, range), countEnd)
        else if (rank{start - 1} < rank{end - 1}) numHumans(start, arr{end - 2}, countStart, countEnd + humanCount(end, range))
        else                                      numHumans(arr{start - 2}, arr{end - 2}, countStart + humanCount(start, range), countEnd + humanCount(end, range))
      }
    }

    def humans(start: Int, end: Int): Int = {
      map.get(start + "_" + end) match {
        case Some(v) => v
        case None    => {
          if (start == end) 1
          else {
            var h = 0
            if (rank{start - 1} > rank{end - 1}) h = humanCount(start, range) + humans(arr{start - 2}, end)
            else if (rank{start - 1} < rank{end - 1}) h = humanCount(start, range) + humans(start, arr{end - 2})
            else h = humanCount(start, range) + humanCount(end, range) + humans(arr{start - 2}, arr{end - 2})
            map.put(start + "_" + end, h)
            h
          }
        }
      }
    }
    numHumans(start, end, 0, 0)
    // humans(start, end)
  }

  def humanCount(x: Int, range: Range): Int = {
    if (x >= range.start && x <= range.end) 1 else 0
  }

}
