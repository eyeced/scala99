package codeeval.medium

/**
 * Created by abhinav on 23/6/14.
 */
object RemoveChars extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val arr = "building ceramic cheap adam, md".split(", ")
    // arr{1}.split("").foldLeft(arr{0})()
    println(arr{1}.split("").foldLeft(arr{0})((str, p) => str.replaceAll(p, "")))

  // }
}
