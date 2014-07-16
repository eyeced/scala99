package codeeval.medium

/**
 * Created by abhinav on 16/7/14.
 */
object ReverseGroups extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(reverseGroups(l))
  }

  def reverseGroups(str: String): String = {
    val arr = str.split(";")
    sliced(arr{0}.split(",").map(_.toInt).toList, arr{1}.toInt, List()).flatten.mkString(",")
  }

  def sliced(list: List[Int], x: Int, acc: List[List[Int]]): List[List[Int]] = list.length match {
    case l if l < x => acc ::: List(list)
    case _          => sliced(list.slice(x, list.length), x, acc ::: List(list.slice(0, x).reverse))
  }
}
