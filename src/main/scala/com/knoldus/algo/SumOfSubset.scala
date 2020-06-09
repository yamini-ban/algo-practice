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

  /*
  def check2(l: Int, y:Int) =   l == y
  def checkSum2(list: List[Int], y: Int): Boolean = {
    def checkbox(list: List[Int], n:Int): Boolean = {
      list match {
        case Nil => false
        case x:: xs =>
          if(x == y) true else if(check2(x+n, y)) {
            true
          }
          else if(checkSum2(xs, y))
            true
          else checkbox(xs, x + n)
      }
    }
    checkbox(list, 0)
  }
*/

}

object Main extends App {
  val array = Array(10,1,2,-3,3,4,2,6)
  println(new SumOfSubset().subSetExistsWithGivenPositiveSum(array, 9))
}
