package codeeval.hard

/**
 * Created by abhinav on 8/7/14.
 */
object ClosestPair extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
  // }

  def closest(arr: Array[(Int, Int)]): Double = {
    if (arr.length == 1) 0
    else if (arr.length == 2) Math.pow(Math.pow(arr{0}._1 - arr{0}._1, 2) + Math.pow(arr{0}._2 - arr{1}._2, 2), 0.5)
    else {
      // compute the right and left array min
      val leftArr = arr.slice(0, arr.length / 2)
      val rightArr = arr.slice(arr.length / 2, arr.length - 1)

      val min = Math.min(closest(leftArr), closest(rightArr))

      // now compute in the mid strip
      val l = (leftArr{0}._1 + rightArr{rightArr.length - 1}._1) / 2

      val strip = leftArr.filter(c => l - c._1 < min) ++ rightArr.filter(c => c._1 - l < min).sortBy(_._2)
      var minStrip = min
      if (strip.length > 1) {
        for {
          i <- 0 until strip.length - 1
          if (distance(strip{i}, strip{i + 1}) < minStrip)
        } yield {
          minStrip = distance(strip{i}, strip{i + 1})
        }
      }
      minStrip
    }
  }

  def distance(x1: (Int, Int), x2: (Int, Int)): Double = {
    Math.pow(Math.pow(x1._1 - x2._1, 2) + Math.pow(x1._2 - x2._2, 2), 0.5)
  }
}
