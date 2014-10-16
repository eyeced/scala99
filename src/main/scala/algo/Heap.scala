package algo

/**
 * Created by abhinav on 16/10/14.
 * Heap class with array to be converted in heap and the operation which would carried out while comparing two elements
 */
class Heap[A](arr: Array[A], op: (A, A) => Boolean) {

  var size = 0
  def heapify(i: Int): Unit = {
    val l = left(i)
    val r = right(i)

    var foo = i
    if (l < size && op(arr{l}, arr{i})) foo = l
    if (r < size && op(arr{r}, arr{foo})) foo = r

    if (foo != i) {
      exchange(i, foo)
      heapify(foo)
    }
  }

  def get(): Option[A] = size match {
    case x if size == 0 => None
    case _ =>
      val v = arr{0}
      arr{0} = arr{size - 1}
      size -= 1
      heapify(0)
      Option(v)
  }

  private def left(i: Int): Int = (2 * i) + 1
  private def right(i: Int): Int = (2 * i) + 2
  private def parent(i: Int): Int = ((i + 1) / 2) - 1

  def exchange(i: Int, j: Int): Unit = {
    val tmp = arr{i}
    arr{i} = arr{j}
    arr{j} = tmp
  }

  override def toString(): String = arr.mkString(" ")

  def main(args: Array[String]) {
    val h = Heap(Array(7, 1, 5, 3, 8, 9, 2, 4), (a: Int, b: Int) => a < b)
    println(h.toString())
  }
}

object Heap {
  def apply[A](arr: Array[A], op: (A, A) => Boolean) = {
    val heap = new Heap(arr, op)
    heap.size = arr.size
    if (heap.size > 0) (0 to (heap.size / 2 - 1)).reverse.foreach(heap.heapify(_))
    heap
  }
}


