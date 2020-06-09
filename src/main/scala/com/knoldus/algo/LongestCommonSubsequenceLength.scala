package com.knoldus.algo

object LongestCommonSubsequenceLength extends App {

  def max(num1: Int, num2: Int): Int = if (num1 >= num2) num1 else num2

  private def nextLength(str: Array[Char]) = str.length - 1

  def getLongestCommonSubsequenceLength(string1: String, string2: String) = {
    def innerGet(str1: Array[Char], str2: Array[Char]): Int = {
      (str1, str2) match {
        case (str1, str2) if str1.length == 0 || str2.length == 0 => 0
        case (str1, str2) if str1(nextLength(str1)) == str2(nextLength(str2)) =>
          1 + innerGet(str1.take(nextLength(str1)), str2.take(nextLength(str2)))
        case (str1, str2) => max(
          innerGet(str1.take(nextLength(str1)), str2),
          innerGet(str1, str2.take(nextLength(str2)))
        )
      }
    }
    innerGet(string1.toCharArray, string2.toCharArray)
  }

  val str1 = "AGGTAB"
  val str3 = "AGGTAB"
  val str2 = "GXTXAYB"
  println(getLongestCommonSubsequenceLength(str1, str2))
}
