package hackerank.contest.funcoct

/**
 * Created by abhinav on 15/10/14.
 */
object OrderExercise {

  class Heap[A](arr: Array[A], op: (A, A) => Boolean) {

    var size = 0

    def build(arr: Array[A], op: (A, A) => Boolean): Heap[A] = {
      println("create")
      val heap = new Heap(arr, op)
      size = arr.size
      if (size > 0) (0 to ((size / 2) - 1)).reverse.foreach(heapify(_))
      heap
    }

    def get(): Option[A] = size match {
      case x if size == 0 => None
      case _ =>
        val value = arr{0}
        arr{0} = arr{size - 1}
        size -= 1
        heapify(0)
        Option(value)
    }

    private def heapify(i: Int): Unit = {
      val l = left(i)
      val r = right(i)

      var min = 0
      if (l < size && op(arr{l}, arr{i})) min = l else min = i
      if (r < size && op(arr{r}, arr{min})) min = r

      if (min != i) {
        exchange(i, min)
        heapify(min)
      }
    }

    private def exchange(i: Int, j: Int): Unit = {
      val tmp = arr{i}
      arr{i} = arr{j}
      arr{j} = tmp
    }

    private def left(i: Int): Int = (2 * i) + 1
    private def right(i: Int): Int = (2 * i) + 2
    private def parent(i: Int): Int = ((i + 1) / 2) - 1

    override def toString(): String = arr.slice(0, size - 1).mkString(" ")
  }

  def main(args: Array[String]) {
    val minHeap = new Heap[Int](Array(3, 6, 8, 2, 5, 4, 9, 10, 7), (a, b) => a < b)
    println(minHeap.toString())
  }
}
