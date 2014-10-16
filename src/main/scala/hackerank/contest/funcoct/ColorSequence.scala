package hackerank.contest.funcoct

/**
 * Created by abhinav on 13/10/14.
 */
object ColorSequence {

  def fullOfColors(list: List[Char], red: Int, green: Int, yellow: Int, blue: Int): String = {
    println(list)
    println(red + " " + green + " " + yellow + " " + blue)
    list match {
      case Nil if (red == green && yellow == blue) => "True"
      case x :: xs if (Math.abs(red - green) < 2 && Math.abs(yellow - blue) < 2) =>
        x match {
          case 'R' => fullOfColors(xs, red + 1, green, yellow, blue)
          case 'G' => fullOfColors(xs, red, green + 1, yellow, blue)
          case 'Y' => fullOfColors(xs, red, green, yellow + 1, blue)
          case 'B' => fullOfColors(xs, red, green, yellow, blue + 1)
        }
      case _ => "False"
    }
  }

  def main(args: Array[String]) {
//    val tests = Console.readLine().toInt
//    (1 to tests).foreach { i =>
//      println(fullOfColors(Console.readLine().toList, 0, 0, 0, 0))
//    }
    println(fullOfColors("RYBG".toList, 0, 0, 0, 0))
  }
}
