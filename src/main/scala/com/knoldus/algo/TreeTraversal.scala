package com.knoldus.algo

case class Node(left: Option[Node], data: Int, right: Option[Node])

object Traversal {
  def inorderTraversal(tree: Node): Any = {
    def innerInOrder(tree: Node): Any = {
      if (tree.left.isDefined) innerInOrder(tree.left.get)
      print(tree.data + " ")
      if (tree.right.isDefined) innerInOrder(tree.right.get)
    }
    innerInOrder(tree)
  }

  def preOrderTraversal(tree: Node): Any = {
    def innerPreOrder(tree: Node): Any = {
      print(tree.data + " ")
      if (tree.left.isDefined) innerPreOrder(tree.left.get)
      if (tree.right.isDefined) innerPreOrder(tree.right.get)
    }
    innerPreOrder(tree)
  }

  def postOrderTraversal(tree: Node): Any = {
    def innerPostOrder(tree: Node): Any = {
      if (tree.left.isDefined) innerPostOrder(tree.left.get)
      if (tree.right.isDefined) innerPostOrder(tree.right.get)
      print(tree.data + " ")
    }
    innerPostOrder(tree)
  }
}

object TreeToList extends App {
  import Traversal._
  val tree1 = Node(Some(Node(Some(Node(Some(Node(None, 6, None)), 4, None)), 2, Some(Node(None, 5, None)))), 1, Some(Node(None, 3, None)))
  val tree2 = Node(Some(Node(None, 2, None)), 1, Some(Node(None, 3, None)))
  inorderTraversal(tree1)
  println()
  preOrderTraversal(tree1)
  println()
  postOrderTraversal(tree1)

}
