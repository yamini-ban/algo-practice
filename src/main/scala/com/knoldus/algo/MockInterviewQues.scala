package com.knoldus.algo

import scala.collection.immutable.ListSet

object MockInterviewQues extends App
{
  import tree._
  val tree1 = Node(Some(Node(Some(Node(Some(Node(None, 6, None)), 4, None)), 2, Some(Node(None, 5, None)))), 1, Some(Node(None, 3, None)))
  val tree2 = Node(Some(Node(None, 2, None)), 1, Some(Node(None, 3, None)))

  println(isBalancedTree(tree1))
  println(isBalancedTree(tree2))

  showResult(convertToList(tree1, isBalancedTree(tree1)))
  showResult(convertToList(tree2, isBalancedTree(tree2)))

  def showResult(list: List[Int]): Unit = list match
  {
    case Nil => println("empty list")
    case list => println(list)
  }

//  BalancedTree=> -1 <= (Height of left subtree - Height of right subtree) <=1


  def convertToList(tree: Node, isBalancedBinaryTree: Boolean): List[Int] = {
    var list = ListSet.empty[Int]
    def inner(tree: Node): Any = {
      if(tree.left.isDefined) inner(tree.left.get)
      list = list ++ ListSet(tree.data)
      if (tree.right.isDefined) inner(tree.right.get)
    }
    if(isBalancedBinaryTree) {
      inner(tree)
      list.toList
    } else List.empty[Int]
  }
}

