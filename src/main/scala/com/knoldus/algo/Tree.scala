package com.knoldus.algo

case class Tree(data: Int, children: List[Tree])

case class Node(left: Option[Node], data: Int, right: Option[Node])
