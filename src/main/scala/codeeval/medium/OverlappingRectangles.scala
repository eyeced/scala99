package codeeval.medium

/**
 * Created by abhinav on 16/7/14.
 */
object OverlappingRectangles extends App {

  type Point = (Int, Int)
  type Rectangle = (Int, Int, Int, Int)

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(isOverlapping(l))
  }

  def isOverlapping(str: String): String = {
    val arr = str.split(",").map(_.toInt)
    val r1 = (arr{0}, arr{1}, arr{2}, arr{3})
    val r2 = (arr{4}, arr{5}, arr{6}, arr{7})
    if (getPoints(r1).filter(p => isInRectangle(p, r2)).isEmpty) "False" else "True"
  }

  def getPoints(r: Rectangle): List[Point] = {
    List((r._1, r._2), (r._1, r._4), (r._3, r._2), (r._3, r._4))
  }

  def isInRectangle(x: Point, r: Rectangle): Boolean = {
    x._1 > r._1 && x._1 < r._3 && x._2 < r._2 && x._2 > r._4
  }
}
