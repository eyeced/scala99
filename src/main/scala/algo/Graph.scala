package algo

/**
 * Created by abhinav on 8/7/14.
 */
trait Graph[A] {

  /**
   * @return the number of vertices
   */
  def V(): Int

  /**
   * @return the number of edges
   */
  def E(): Int

  /**
   * connect two vertices
   * @param v vertex
   * @param w vertex
   * @return changed graph
   */
  def addEdge(v: A, w: A)

  /**
   * get all connected components to the vertex v
   * @param v vertex
   * @return list of vertices connected to v
   */
  def adj(v: A): List[A]

  /**
   * @return the reversed graph
   */
  def reverse(): Graph[A]

}
