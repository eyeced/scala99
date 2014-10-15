package codeeval.hard

import scala.collection.immutable.HashMap
import scala.collection.mutable

/**
 * Created by abhinav on 10/7/14.
 */
object PeakTraffic extends App {

  case class DiGraph[A](adj: mutable.HashMap[A, List[A]] = new mutable.HashMap[A, List[A]]()) {

    def addEdge(v: A, w: A) {
      adj.get(v) match {
        case Some(l) => adj.put(v, w :: l)
        case None    => adj.put(v, List(w))
      }
      if (!adj.contains(w)) {
        adj.put(w, List())
      }
    }

    def reverse(): DiGraph[A] = {
      val reverse = new DiGraph[A]()
      adj.keySet.foreach(k => adjacency(k).foreach(w => reverse.addEdge(w, k)))
      reverse
    }

    def adjacency(key: A): List[A] = {
      adj.get(key) match {
        case Some(l) => l
        case None    => Nil
      }
    }

    def numOfVertices(): Int = adj.keySet.size

    def reverseDfsPost(): List[A] = {
      val markedMap = new mutable.HashMap[A, Boolean]()
      adj.keySet.foreach(a => markedMap.put(a, false))
      List()
    }

    def dfs(marked: mutable.HashMap[A, Boolean], list: List[A], acc: List[A]): List[A] = list match {
      case x :: Nil => acc ::: List(x)
      case x :: xs  => List()
    }
  }



}
