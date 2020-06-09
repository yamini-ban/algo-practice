package com.knoldus.algo

import scala.collection.mutable

class SumOfSubArrayIsZero {
  def isSumOfSubArrayZero(array: Array[Int]) = {
    val set = mutable.HashSet.empty[Int]
    def innerChecker(list: List[Int], sum: Int): Boolean = {
      list match {
        case first :: _ if set.contains(first + sum) => true
        case first :: rest => set.add(sum + first)
          innerChecker(rest, sum + first)
        case Nil => false
      }
    }
    innerChecker(array.toList, 0)
  }

  def isSumOfSubArrayEqualsGiven(array: Array[Int], originalSum: Int) = {
    val set = mutable.HashSet.empty[Int]
    def innerChecker(list: List[Int], sum: Int): Boolean = {
      list match {
        case first :: rest if
          first == originalSum ||
          sum + first == originalSum ||
          innerChecker(rest, sum + first) ||
          innerChecker(rest, sum) => true
        case _ => false
      }
    }
    innerChecker(array.toList, 0)
  }
}

object SumOfSubArrayIsZero extends App {
  val array = Array(10,1,2,-5,3,4,2,6)
  val obj = new SumOfSubArrayIsZero()
  println(obj.isSumOfSubArrayZero(array))
  println(obj.isSumOfSubArrayEqualsGiven(array, -6))
}
