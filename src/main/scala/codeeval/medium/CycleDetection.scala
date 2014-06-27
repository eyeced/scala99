package codeeval.medium

/**
 * Created by abhinav on 12/6/14.
 */
object CycleDetection extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    printLoop(l.split(" ").toList.map(s => s.toInt))
  }

  def printLoop(seq: List[Int]) {
    val arr = (0 until 100).toArray.map(_ => 0)
    createUnion(seq, arr)
    println(floyd(arr, seq.head).mkString(" "))
  }

  def createUnion(l: List[Int], a: Array[Int]): Array[Int] = l match {
    case x :: Nil => a
    case x :: xs => a{x} = xs.head
      createUnion(xs, a)
  }

  def floyd(arr: Array[Int], start: Int): List[Int] = {

    def kPos(tortoise: Int, hair: Int, a: Array[Int]): Int = {
      if (tortoise == hair) tortoise
      else kPos(a{tortoise}, a{a{hair}}, a)
    }

    def mu(tortoise: Int, hair: Int, a: Array[Int]): Int = {
      if (tortoise == hair) tortoise
      else mu(a{tortoise}, a{hair}, a)
    }

    def lambda(tortoise: Int, hair: Int, a: Array[Int], lam: Int): Int = {
      if (tortoise == hair) lam
      else lambda(a{tortoise}, hair, a, lam + 1)
    }

    // get the k position where tortoise and hair meet
    val k = kPos(arr{start}, arr{arr{start}}, arr)
    // now get the mu value, i.e the start of the loop index, by keeping hair at k position
    val startLoop = mu(start, k, arr)
    // now we have got the index of from where loop starts, get the length of the loop
    val length = lambda(arr{startLoop}, startLoop, arr, 1)

    def sec(pos: Int, a: Array[Int], l: List[Int], len: Int): List[Int] = {
      if (len == 0) l
      else sec(a{pos}, a, l ::: List(a{pos}), len - 1)
    }
    sec(startLoop, arr, List(startLoop), length - 1)
  }
}
