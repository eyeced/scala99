package hackerank.contest.funcoct

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Created by abhinav on 16/10/14.
 */
object OrderExercise {

  def maxSum(list: List[Int], i: Int, acc: ArrayBuffer[((Int, Int), Int)], cur: ((Int, Int), Int), max: ((Int, Int), Int)): Array[((Int, Int), Int)] = list match {
    case Nil =>
      acc.append(max)
      acc.toArray

    case x :: xs if x > 0 =>
      val foo = ((cur._1._1, i), cur._2 + x)
      if (foo._2 > max._2) maxSum(xs, i + 1, acc, foo, foo)
      else maxSum(xs, i + 1, acc, foo, max)

    case x :: xs =>
      val newSum = cur._2 + x
      newSum match {
        case _ if newSum < 0 =>
          if (max._2 > 0) acc.append(max)
          maxSum(xs, i + 1, acc, ((i + 1, i + 1), 0), ((i + 1, i + 1), 0))
        case _ =>
          maxSum(xs, i + 1, acc, ((cur._1._1, i), cur._2 + x), max)
      }
  }

  def buildGraph(arr: Array[Int], maxArrs: Array[((Int, Int), Int)]): (Graph, Array[(Int, (Int, Int), Int)] = {
    val foo = new Array[ArrayBuffer[Int]](10000).map { _ => new ArrayBuffer[Int]() }
    val maxArrIdx = (0 to (maxArrs.size - 1)).map { i => (i, maxArrs{i}._1, maxArrs{i}._2) }

    val graph = new Graph(maxArrs.size)

    maxArrIdx.foreach { a =>
      val t = a._2
      (t._1 to t._2).foreach { i =>
        val buf = foo{arr{i}}
        if (buf.size != 0) buf.foreach { x => graph.addEdge(a._1, x) }
        buf.append(a._1)
      }
    }
    (graph, maxArrIdx.toArray)
  }

  def disjointSets(list: List[Int]): List[Int] = {
    // get all max sum arrays from the list
    val maxSumArr = maxSum(list, 0, new ArrayBuffer[((Int, Int), Int)](), ((0, 0), 0), ((0, 0), 0))

    // create the connected graph of the joint sets
    val tuple = buildGraph(list.toArray, maxSumArr)
    val graph = tuple._1
    val arr = tuple._2

    // create the heap from the array
    val heap = Heap(arr, (x: (Int, (Int, Int), Int), y: (Int, (Int, Int), Int)) => x._3 > y._3 || x._2._1 < y._2._1 || (x._2._2 - x._2._1) < (y._2._2 - y._2._1))
    Nil
  }

  class Graph(v: Int) {

    val map = new mutable.HashMap[Int, mutable.HashSet[Int]]()

    /**
     * @return the number of vertices
     */
    def V(): Int = map.keySet.size

    /**
     * get all connected components to the vertex v
     * @param v vertex
     * @return list of vertices connected to v
     */
    def adj(v: Int): mutable.HashSet[Int] = map.get(v) match {
      case Some(l) => l
      case None    => mutable.HashSet()
    }

    /**
     * connect two vertices
     * @param v vertex
     * @param w vertex
     * @return changed graph
     */
    def addEdge(v: Int, w: Int) = {
      adj(v) += w
      adj(w) += v
    }

    /**
     * remove the edge
     * @param v
     * @param w
     * @return
     */
    def removeEdge(v: Int, w: Int) = {
      adj(v) -= w
      adj(w) -= v
    }

    /**
     * @return the number of edges
     */
    def E(): Int = {
      map.keySet.foldLeft(0)((x, y) => adj(x).size + y)
    }
  }
  /**
   * Heap inner class used for heapifying the array
   * @param arr the array
   * @param op function applied on two elements while comparing
   * @tparam A
   */
  class Heap[A](arr: Array[A], op: (A, A) => Boolean) {
    var size = 0
    def heapify(i: Int): Unit = {
      println("heapify - " + i)
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

    def remove(i: Int): Unit = {
      if (i < size) {
        arr{i} = arr{size - 1}
        size -= 1
        heapify(i)
      }
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
  }

  object Heap {
    def apply[A](arr: Array[A], op: (A, A) => Boolean) = {
      val heap = new Heap(arr, op)
      heap.size = arr.size
      if (heap.size > 0) (0 to (heap.size / 2 - 1)).reverse.foreach(heap.heapify(_))
      heap
    }
  }

  def main(args: Array[String]) {
//    val h = Heap.apply(Array(7, 1, 5, 3, 8, 9, 2, 4), (a: Int, b: Int) => a < b)
//    println(h.toString())
    println(maxSum(List(-2, -4, 10, 4, -2, 3, -19, 2, 3), 0, new ArrayBuffer[((Int, Int), Int)](), ((0, 0), 0), ((0, 0), 0)).mkString(" "))
  }
}
