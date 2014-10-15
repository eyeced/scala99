package hackerank.contest.codesprint

/**
 * Created by abhinav on 17/9/14.
 */
object RabbitJump {

  def numOfJumps(p: Int): Int = {
    def jumps(jump: Int, pos: Int): Int = {
      if (pos + jump + 1 >= p) jump
      else jumps(jump + 1, pos + jump + 1)
    }
    jumps(1, 0)
  }

  def main(args: Array[String]) {
//    val t = Console.readInt()
//    (1 to t).foreach { i =>
      println(numOfJumps(Console.readInt()))
//    }
  }
}
