package com.knoldus.algo

class Stack {
  private var min = Int.MaxValue
  var stack = List.empty[Int]

  def minimum(min: Int, element: Int): Int = if (element <= min) element else min

  def push(element: Int) = {
    stack = element :: stack
    min = minimum(min, element)
    element
  }
  def pop() = {
    val popped = stack match {
      case first :: rest => stack = rest
      case Nil => stack = Nil
    }
    min = stack.foldLeft(Int.MaxValue)((mini, element) => minimum(mini, element))
  }

  def getMin() = {
    if (stack.nonEmpty) min else Int.MinValue
  }
}

object MAin extends App {
  val stack = new Stack
  stack.push(2)
  stack.push(4)
  stack.push(1)
  stack.push(3)
  stack.push(-1)
  stack.pop()
  stack.pop()
  stack.pop()
  stack.pop()
  stack.pop()
  println(stack.getMin())

}