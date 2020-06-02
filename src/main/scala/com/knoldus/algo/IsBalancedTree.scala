package com.knoldus.algo

object tree {
  def isBalancedTree(root: Node): Boolean = {
    val difference: Int = height(root.left) - height(root.right)
    if (difference <= 1 && difference >= -1) true
    else false
  }


  def max(element1: Int, element2: Int): Int = if (element1 >= element2) element1 else element2

  private def height(node: Option[Node]): Int = {
    node match {
      case Some(node: Node) => 1 + max(height(node.left), height(node.right))
      case None => 0
    }
  }
}

object IsBalancedTree extends App {
  import tree._
  val tree1 = Node(Some(Node(Some(Node(Some(Node(None, 6, None)), 4, None)), 2, Some(Node(None, 5, None)))), 1, Some(Node(None, 3, None)))
  val tree2 = Node(Some(Node(Some(Node(Some(Node(None, 5, Some(Node(None, 5, None)))), 5, None)), 2, None)), 1, Some(Node(None, 3, None)))
  println(isBalancedTree(tree2))

}
