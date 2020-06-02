package com.knoldus.algo

object CountNodesInTree extends App {
  val tree1 = Node(Some(Node(Some(Node(Some(Node(None, 6, None)), 4, None)), 2, Some(Node(None, 5, None)))), 1, Some(Node(None, 3, None)))
  val tree2 = Node(Some(Node(None, 2, None)), 1, Some(Node(None, 3, None)))

  def countNodesInTree(tree: Node): Int = {
    (tree.left, tree.right) match {
      case (Some(left: Node), Some(right: Node)) => 1 + countNodesInTree(left) + countNodesInTree(right)
      case (Some(left: Node), None) => 1 + countNodesInTree(left)
      case (None, Some(right: Node)) => 1 + countNodesInTree(right)
      case (None, None) => 1
    }
  }

  println(countNodesInTree(tree1))

  def countLeafNodesInTree(tree: Node): Int = {
    (tree.left, tree.right) match {
      case (Some(left: Node), Some(right: Node)) => countLeafNodesInTree(left) + countLeafNodesInTree(right)
      case (Some(left: Node), None) => countLeafNodesInTree(left)
      case (None, Some(right: Node)) => countLeafNodesInTree(right)
      case (None, None) => 1
    }
  }

  println(countLeafNodesInTree(tree1))

}
