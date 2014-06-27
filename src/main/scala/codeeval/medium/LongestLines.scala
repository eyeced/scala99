package codeeval.medium

import scala.collection.mutable

/**
 * Created by abhinav on 11/6/14.
 */
object LongestLines extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  var i = 0;

  def len(s: String) = - s.length
  var n = 0

  val queue = new scala.collection.mutable.PriorityQueue[String]()(Ordering.by(len))
  for (l <- lines) {
    if (i != 0 ) {
      if (queue.size == n) {
        if (queue.head.length < l.length) {
          queue.dequeue()
          queue.enqueue(l)
        }
      } else queue.enqueue(l)
    }
    else {
      n = l.toInt
      i += 1
    }
  }

  while (queue.isEmpty) {
    println(queue.dequeue())
  }
}
