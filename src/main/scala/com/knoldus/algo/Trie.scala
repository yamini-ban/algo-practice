package com.knoldus.algo

class Trie() {
  val noOfChildNode = 26
  var children: Array[Trie] = Array.tabulate(noOfChildNode)(_ => null)
  var isEnd: Boolean = false
  def insert(word: String): String = {
    val length = word.length
    var root = this
    for (itr <- 0 until length) {
      val index = word.charAt(itr) - 'a'
      if(root.children(index) == null)
        root.children(index) = new Trie()
      root = root.children(index)
    }
    root.isEnd = true
    word
  }
  def search(word: String) = {
    var root = this

    val result = (0 until word.length).foldLeft(true)((res, itr) => {
      val index = word.charAt(itr) - 'a'
      if(root.children(index) != null) {
        root = root.children(index)
        if (res) true else false
      }
      else false
    })

    result && root.isEnd && root != null
  }
}

object MaIn extends App {
  val tree = new Trie()
  println(tree.insert("yamini"))
  println(tree.insert("bansal"))
  println(tree.insert("there"))
  println(tree.insert("the"))

//  println(tree.children(19).children(7).children(8) == null)

  println(tree.search("there"))
  println(tree.search("thie"))
  println(tree.search("ther"))
  println(tree.search("banini"))


}
