package com.knoldus.algo

object nodes {
  def countNodesInTree(tree: Node): Int = {
    (tree.left, tree.right) match {
      case (Some(left: Node), Some(right: Node)) => 1 + countNodesInTree(left) + countNodesInTree(right)
      case (Some(left: Node), None) => 1 + countNodesInTree(left)
      case (None, Some(right: Node)) => 1 + countNodesInTree(right)
      case (None, None) => 1
    }
  }

  def countLeafNodesInTree(tree: Node): Int = {
    (tree.left, tree.right) match {
      case (Some(left: Node), Some(right: Node)) => countLeafNodesInTree(left) + countLeafNodesInTree(right)
      case (Some(left: Node), None) => countLeafNodesInTree(left)
      case (None, Some(right: Node)) => countLeafNodesInTree(right)
      case (None, None) => 1
    }
  }

  def countNodesWithMoreThanGivenChildren(tree: Tree, childrenCount: Int): Int = {
    def innerCount(tree: Tree): Int = {
      if (tree.children.size > childrenCount)
        tree.children.foldLeft(1)((count, child) => count + innerCount(child))
      else if (tree.children.isEmpty) 0
      else tree.children.foldLeft(0)((count, child) => count + innerCount(child))
    }
    innerCount(tree)
  }
}

object CountNodesInTree extends App {
  import nodes._
  val tree1 = Node(Some(Node(Some(Node(Some(Node(None, 6, None)), 4, None)), 2, Some(Node(None, 5, None)))), 1, Some(Node(None, 3, None)))
  val tree2 = Node(Some(Node(None, 2, None)), 1, Some(Node(None, 3, None)))

  val treeNode = Tree(12, List.empty[Tree])
  val tree = Tree(2, List(treeNode,treeNode, treeNode))
  val treeT = Tree(2, List(tree, treeNode, tree))

  println(countNodesInTree(tree1))

  println(countLeafNodesInTree(tree1))

  println(countNodesWithMoreThanGivenChildren(treeT, 2))

}
