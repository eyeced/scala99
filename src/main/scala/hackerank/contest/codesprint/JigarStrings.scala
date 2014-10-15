package hackerank.contest.codesprint

import scala.collection.parallel.mutable

/**
 * Created by abhinav on 18/9/14.
 */
object JigarStrings {

  def changes(str: String): Int = {
    val a = new Array[Int](26)
    str.foreach { c =>
      a{c.toInt - 97} += 1
    }
    // a.filter(_ > 0).groupBy(_)
    1
  }
}
