package com.knoldus.algo

import scala.collection.mutable

class SumOfSubset {
  def subSetExistsWithGivenPositiveSum(array: Array[Int], sum: Int): Boolean = {
    def innerSubset(list: List[Int], sum: Int): Boolean = {
      list match {
        case _ if sum == 0 => true
        case _ if sum < 0 => false
        case first :: rest => innerSubset(rest, sum - first) | innerSubset(rest, sum)
        case Nil => false
      }
    }
    innerSubset(array.toList, sum)
  }
  def isSumOfSubsetZero(array: Array[Int]): Boolean = {
    val set = mutable.HashSet.empty[Int]
    array.foreach(set.add)
@scala.annotation.tailrec
    def innerSubset(list: List[Int], sum: Int): Boolean = {
      list match {
        case first :: rest if sum + first > sum =>
          set.add(sum + first)
          innerSubset(rest, first + sum)
        case first :: _ if set.contains(sum + first) || set.contains(-first) => true
        case first :: rest => set.add(sum + first)
          innerSubset(rest, first + sum)
        case Nil if sum > 0 || sum < 0 => false
        case Nil => true
      }
    }
    innerSubset(array.toList, 0)
  }
}

object Main extends App {
  val array = Array(10,1,2,3,-17,3,4,2,6)
  println(new SumOfSubset().subSetExistsWithGivenPositiveSum(array, 9))
//  val set = mutable.HashSet.empty[Int]
//  array.foreach(element => set.add(element))
//  set.foreach(println)
  println(new SumOfSubset().isSumOfSubsetZero(array))
}
