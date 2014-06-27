package codeeval.medium

/**
 * Created by abhinav on 22/6/14.
 */
object MthFromLast extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val list = "a b c d 2".split(" ").toList
    val m = list.last.toInt
    val items = list.slice(0, list.length - 1)
    println(items)
    if (m > items.length) {
      throw new NoSuchElementException
    }
    println(mth(items, items, m, items.length - m))
  // }

  def mth(mList: List[String], nList: List[String], m: Int, n: Int): String = {
    println(mList + "        " + nList + "    " + m + "      " + n)
    (mList, nList, m, n) match {
      case (_, x :: xs, 0, 0) => x
      case (mxs, x :: xs, 0, a) => mth(mxs, xs, 0, a - 1)
      case (x :: xs, nxs, b, a) => mth(xs, nxs, b - 1, a)
    }
  }

}
