package com.fun

import scala.collection.immutable.Stack

/**
 * Created by abhinav on 9/8/14.
 */
object Histogram extends App {

  type Element = (Int, Int)

  def largestHist(list: List[Int], stack: List[Element], max: Int, idx: Int): Int = (list, stack) match {
    case (Nil, Nil)           => max
    case (x :: xs, Nil)       => largestHist(xs, List((x, idx)), max, idx + 1)
    case (Nil, y :: Nil)      => Math.max(max, y._1 * idx)
    case (Nil, y :: ys)       => largestHist(Nil, ys, Math.max(max, (idx - 1 - ys.head._2) * y._1), idx)
    case (x :: xs, y :: Nil)  => if (x >= y._1) largestHist(xs, ((x, idx) :: stack), max, idx + 1) else largestHist(list, Nil, Math.max(max, (idx) * y._1), idx)
    case (x :: xs, y :: ys)   => if (x >= y._1) largestHist(xs, ((x, idx) :: stack), max, idx + 1) else largestHist(list, ys, Math.max(max, (idx - 1 - ys.head._2) * y._1), idx)
  }

  println(largestHist(List(3, 2, 5, 6, 1, 4, 4), Nil, 0, 0))

}
