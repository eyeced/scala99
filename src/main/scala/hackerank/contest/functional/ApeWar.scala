package hackerank.contest.functional



/**
 * Created by abhinav on 13/9/14.
 */
object ApeWar {

  def main(args: Array[String]) {

    // val line1Arr = Console.readLine().split(" ").map(_.toInt)
    // val n = line1Arr{0}
    // val m = line1Arr{1}

    // val arr = Console.readLine().split(" ").map(_.toInt)
    val arr = Array(4, 2, 1, 1, 3, 4, 5, 6)
    val rank = new Array[Int](9)

    def getRank(i: Int, count: Int): Int = arr{i - 2} match {
      case 1 => 1 + count
      case x => getRank(x, count + 1)
    }

    (1 to arr.length).par.foreach { x =>
      rank{x} = getRank(x + 1, 0)
    }

    println(rank.mkString(", "))
    println(process(arr, rank, "4 9 1 4"))
    println(process(arr, rank, "1 7 1 4"))

    // val buf = new scala.collection.mutable.ArrayBuilder.ofRef[String]()

    // (1 to m).foreach{ x =>
    //  buf += Console.readLine()
    // }
    // println(buf.result().map { s => process(arr, rank, s) }.mkString("\n"))
  }

  def process(arr: Array[Int], rank: Array[Int], message: String): Int = {
    val a = message.split(" ").map(_.toInt)
    val start = a{0}
    val end = a{1}
    val range = a{2} to a{3}

    def numHumans(start: Int, end: Int, countStart: Int, countEnd: Int): Int = {
      println(start + "  " + end)
      if (start == end) {
        if (range.contains(start)) countStart + 1 + countEnd else countStart + countEnd
      } else {
        if (rank{start - 1} > rank{end - 1})      numHumans(arr{start - 2}, end, countStart + humanCount(start, range), countEnd)
        else if (rank{start - 1} < rank{end - 1}) numHumans(start, arr{end - 2}, countStart, countEnd + humanCount(end, range))
        else                                      numHumans(arr{start - 2}, arr{end - 2}, countStart + humanCount(start, range), countEnd + humanCount(end, range))
      }
    }
    numHumans(start, end, 0, 0)
  }

  def humanCount(x: Int, range: Range): Int = {
    if (x >= range.start && x <= range.end) 1 else 0
  }
}
