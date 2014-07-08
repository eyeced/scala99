package algo

import scala.collection.mutable

/**
 * Created by abhinav on 8/7/14.
 */
class DiGraph(v: Int) extends Graph[Int] {

  val map = new mutable.HashMap[Int, List[Int]]()

  /**
   * @return the number of vertices
   */
  override def V(): Int = map.keySet.size

  /**
   * get all connected components to the vertex v
   * @param v vertex
   * @return list of vertices connected to v
   */
  override def adj(v: Int): List[Int] = map.get(v) match {
    case Some(l) => l
    case None    => Nil
  }

  /**
   * connect two vertices
   * @param v vertex
   * @param w vertex
   * @return changed graph
   */
  override def addEdge(v: Int, w: Int) = {
    map.put(v, w :: adj(v))
  }

  /**
   * @return the number of edges
   */
  override def E(): Int = {
    map.keySet.foldLeft(0)((x, y) => adj(x).length + y)
  }

  /**
   * @return the reversed graph
   */
  override def reverse(): Graph[Int] = {
    val r = new DiGraph(V())
    map.keySet.foreach(k => adj(k).foreach(x => r.addEdge(x, k)))
    r
  }
}
