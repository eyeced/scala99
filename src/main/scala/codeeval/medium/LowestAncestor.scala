package codeeval.medium

/**
 * Created by abhinav on 23/6/14.
 */
object LowestAncestor extends App {
  trait Tree
  case class Node(x: Int, left: Tree, right: Tree) extends Tree
  object EmptyNode extends Tree

  def ancestor(root: Tree, a: Int, b: Int): Tree = root match {
    case n: Node => if ((n.x > a && n.x < b) || n.x == a || n.x == b) n
      else if (n.x > a && n.x > b) ancestor(n.left, a, b)
      else ancestor(n.right, a, b)
    case _ => EmptyNode
  }

  val root = Node(30, Node(8, Node(3, EmptyNode, EmptyNode), Node(20, Node(10, EmptyNode, EmptyNode), Node(29, EmptyNode, EmptyNode))), Node(52, EmptyNode, EmptyNode))

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val arr = "3 29".split(" ").map(s => s.toInt)
    ancestor(root, arr{0}, arr{1}) match {
      case n: Node => println(n.x)
      case _ => // do nothing
    }
  //}
}
