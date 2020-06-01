package com.knoldus.algo

case class Node(left: Option[Node], data: Int, right: Option[Node])

object TreeToList extends App {
  val tree1 = Node(Some(Node(Some(Node(Some(Node(None, 6, None)), 4, None)), 2, Some(Node(None, 5, None)))), 1, Some(Node(None, 3, None)))
  val tree2 = Node(Some(Node(None, 2, None)), 1, Some(Node(None, 3, None)))
  //
  //  showResult(convertToList(tree1, true))//isBalancedBinaryTree(tree1)))
  //  showResult(convertToList(tree2, true))//isBalancedBinaryTree(tree2)))
  convertToList(tree2, true)

  def showResult(list: List[Int]): Unit = list match {
    case Nil => println("empty list")
    case list => println(list)
  }

  //  def isBalancedBinaryTree(tree: Node): Boolean = {
  //    def innerIsBalancedBinaryTree(tree: Node, currentDifference: Int): Boolean = {
  //      tree match {
  ////        case node: Node if node.left != None && node.right != None => innerIsBalancedBinaryTree(node.left, currentDifference)
  ////
  ////        case node: Node if node.left == None && node.right != None => innerIsBalancedBinaryTree(node.right, currentDifference - 1)
  ////
  ////        case node: Node if node.left != None && node.right == None => innerIsBalancedBinaryTree(node.right, currentDifference + 1)
  ////
  ////        case None if currentDifference > 1 || currentDifference < -1 => false
  ////
  ////        case None if currentDifference <= 1 && currentDifference >= -1 => true
  //      }
  //    }
  //
  //    innerIsBalancedBinaryTree(tree, 0)
  //
  //  }

  def convertToList(tree: Node, isBalancedBinaryTree: Boolean): List[Int] = {

    def innerConvertToList(tree: Node, finalList: List[Int]): List[Int] = {
      if (tree.left.isDefined) innerConvertToList(tree.left.get, finalList) ::: List(tree.data)
      if (tree.right.isDefined)
        innerConvertToList(tree.right.get, finalList)
    }

    innerConvertToList(tree, List.empty)


  }
}
