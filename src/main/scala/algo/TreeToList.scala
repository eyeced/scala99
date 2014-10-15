package algo

/**
 * Created by abhinav on 7/9/14.
 */
object TreeToList {

  trait TreeNode
  case class Node(v: Int, left: TreeNode, right: TreeNode) extends TreeNode
  object EmptyNode extends TreeNode

  def treeToList(root: TreeNode): List[Int] = root match {
    case EmptyNode => List()
    case x: Node   => treeToList(x.left) ::: List(x.v) ::: treeToList(x.right)
  }

  def main(args: Array[String]) {
    val root = Node(30, Node(8, Node(3, EmptyNode, EmptyNode), Node(20, Node(10, EmptyNode, EmptyNode), Node(29, EmptyNode, EmptyNode))), Node(52, EmptyNode, EmptyNode))
    println(treeToList(root))
  }

}
