package codeeval.hard

/**
 * Created by abhinav on 26/6/14.
 */
object SubString extends App {
  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val s = "hrJOyIpECd8o27VdQEuqhdSS,O\\*Cd8o27".split(",")
    println(search(s{1}, s{0}))
  // }

  def search(seq: String, str: String): Boolean = {
    if (seq.indexOf("\\*") > 0) {
      val arr = seq.split("\\\\\\*")
      str.indexOf(arr{0}) > -1 && str.indexOf(arr{1}) > -1 && str.indexOf(arr{0}) < str.indexOf(arr{1})
    } else if (seq.indexOf("*") > 0) {
      val arr = seq.split("*")
      str.indexOf(arr{0}) > -1 && str.indexOf(arr{1}) > -1 && str.indexOf(arr{0}) < str.indexOf(arr{1})
    } else {
      str.indexOf(seq) > -1
    }
  }
}
