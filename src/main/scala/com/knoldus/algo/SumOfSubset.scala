package com.knoldus.algo

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

  def sumOfSubsetIsZeroExists(array: Array[Int]): Boolean = {
    def innerChecker(list: List[Int], sum: Int): Boolean = {
      list match {
        case first :: rest if first+sum != 0 => innerChecker(rest, sum + first) || innerChecker(rest, sum)
        case first :: _ if first+sum == 0 => true
        case Nil => false
      }
    }
    innerChecker(array.toList, 0)
  }

}

object Main extends App {
  val array = Array(-1,-10,3,3,4,2,6)
  val obj = new SumOfSubset
//  println(obj.subSetExistsWithGivenPositiveSum(array, 9))
  println(obj.sumOfSubsetIsZeroExists(array))
}
