/**
 * Created by abhinav on 23/6/14.
 */
object Main extends App {
  val map = Map(
    0 -> List(0, 8),
    1 -> List(0, 1, 3, 4, 7, 8, 9),
    2 -> List(2, 8),
    3 -> List(3, 8, 9),
    4 -> List(4, 8, 9),
    5 -> List(5, 6, 8, 9),
    6 -> List(6, 8),
    7 -> List(0, 7, 8, 9),
    8 -> List(8),
    9 -> List(8, 9)
  )

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  var i = 0
  var numTests = 0
  for (l <- lines) {
    if (i == 0) {
      numTests = l.toInt
      i += 1
    }
    else {
      if (i <= numTests) {
        val arr = l.split(" ")
        println(deface(arr{0}, arr{1}))
        i += 1
      }
    }
  }

  def deface(marks: String, max: String): String = {
    // let us first get all possible defaces number from the given number x and let us choose the largest from them
    val arr = getListOfDefaces(marks, max)

    val combinations = getCombinations(arr.map(l => l.map(i => i.toString)))

    val lessThanDigits = combinations.filter(c => c.toInt <= max.toInt)

    getMax(lessThanDigits).toString
  }

  def getListOfDefaces(marks: String, max: String): List[List[Int]] = {
    val arr = marks.split("").toList.map(s => s.toInt).map(a => map.get(a) match {
      case Some(l) => l
      case None => List()
    })
    if (max.length > marks.length) {
      val pre = max.substring(0, max.length - marks.length).toInt
      List(pre, pre - 1) :: arr
    } else {
      arr
    }
  }

  def getMax(list: List[String]): Int = {
    var max = 0
    list.foreach(x => if (x.toInt > max) max = x.toInt)
    max
  }

  def combinations(chars: List[String], combs: List[String]): List[String] = combs match {
    case List() => chars
    case _ =>
      for {
        ch <- chars
        c <- combs
      } yield ch + c
  }

  def getCombinations(listOfChars: List[List[String]]): List[String] = listOfChars match {
    case Nil => Nil
    case l :: Nil => l
    case l :: ls => combinations(l, getCombinations(ls))
  }
}
