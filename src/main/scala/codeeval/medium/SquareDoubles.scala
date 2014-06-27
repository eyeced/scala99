package codeeval.medium

/**
 * Created by abhinav on 23/6/14.
 */
object SquareDoubles extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    val x = "25".toInt
    val root = Math.pow(x, 0.5)
    val pairs = for {
      r <- 0 until root.toInt + 1
      s <- 0 until root.toInt + 1
      if (r * r + s * s == x)
    } yield (r, s)
    println(pairs.length / 2)
  }
}
