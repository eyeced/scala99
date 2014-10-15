package hackerank.contest.functional

/**
 * Created by abhinav on 6/9/14.
 */
object Puzzle {

  type Point = (Int, Int)
  type Tromino = (Point, Point, Point)
  type Cell = ((Point), Int)
  type Board = Array[Array[Point]]


  def tile(board: Board, x: Point): List[Tromino] = {
    if (board.length == 2) {
      val t = board.flatten.filter { a => a != x }
      List((t{0}, t{1}, t{2}))
    } else {
      // split the board in four parts
      val sp : (List[(Board, Point)], Tromino) = split(board, x)
      val boardPoint = sp._1
      sp._2 :: (for {
        b <- boardPoint
      } yield tile(b._1, b._2)).flatten
    }
  }

  def split(board: Board, x: Point): (List[(Board, Point)], Tromino) = {
    // length of new boards
    val len = board.length
    val foo = board.length / 2
    // get the split up boards
    val p1 = board{0}{0}
    val i = p1._1
    val j = p1._2

    // get the limits of the boards in row major form
    val limits = List((p1, (i + foo - 1, j + foo - 1)), ((i, j + foo), (i + foo - 1, j + len - 1)), ((i + foo, j), (i + len - 1, j + foo - 1)), ((i + foo, j + foo), (i + len - 1, j + len - 1)))
    // get the boards
    // val bar: List[Board] = limits.map { l => board.filter { xs => xs.filter { p => inLimit(p, l) }.length > 0 } }
    val flat = board.flatten
    val bar = limits.map { l => flat.filter { p => inLimit(p, l) }.toList }.map { l => listTo2dArray(l, foo) }

    // now get the board in which the adjoining squares
    val list = adjSquares(bar, 0).map { b => if (pointIn(b._1, x)) (b._1, x) else b }
    val ts = list.filter { l => l._2 != x }.map(_._2).toArray
    (list, (ts{0}, ts{1}, ts{2}))
  }

  def listTo2dArray(list: List[Point], len: Int): Array[Array[Point]] = {
    val map = list.zipWithIndex.groupBy { case (p, i) => i / len }
    map.keySet.toList.sorted.map { k => map.get(k).get.map(_._1).toArray }.toArray
  }

  def adjSquares(list: List[Board], count: Int): List[(Board, Point)] = (list, count) match {
    case (x :: xs, 0) => (x, x{x.length - 1}{x.length - 1}) :: adjSquares(xs, 1)
    case (x :: xs, 1) => (x, x{x.length - 1}{0}) :: adjSquares(xs, 2)
    case (x :: xs, 2) => (x, x{0}{x.length - 1}) :: adjSquares(xs, 3)
    case (x :: Nil, 3) => List((x, x{0}{0}))
  }

  def pointIn(b: Board, p: Point): Boolean = {
    p._1 >= b{0}{0}._1 && p._1 <= b{b.length - 1}{b.length - 1}._1 && p._2 >= b{0}{0}._2 && p._2 <= b{b.length - 1}{b.length - 1}._2
  }

  def inLimit(p: Point, l: (Point, Point)): Boolean = {
    p._1 >= l._1._1 && p._1 <= l._2._1 && p._2 >= l._1._2 && p._2 <= l._2._2
  }

  def main(args: Array[String]) {
    // val a = Array(Array(0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 1, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0),
    //  Array(0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0)).zipWithIndex.map { case (xs, i) => xs.zipWithIndex.map { case (ys, j) => (i + 1, j + 1) } }
    // println(tile(a, (3, 3)))

    val n = Math.pow(2, Console.readInt()).toInt
    val s = Console.readLine()
    val arr = s.split(" ").map(_.toInt)
    val p = (arr{0}, arr{1})
    val a = (1 to n).map { x => (1 to n).map { y => (x, y) }.toArray }.toArray
    tile(a, p).foreach { t => println(List(t._1, t._2, t._3).map { p => p._1 + " " + p._2 }.mkString(" ")) }
  }

}
