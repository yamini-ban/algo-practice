package com.knoldus.algo

import scala.collection.mutable

case class Cache(set: mutable.LinkedHashSet[Int], size: Int)

class LRUCache {
  def add(cache: Cache, item: Int) = {
    cache match {
      case Cache(set, _) if set.contains(item) =>
        set.remove(item)
        set.add(item)
      case Cache(set, size) if set.size == size => set.remove(set.head)
        set.add(item)
      case Cache(set, _) => set.add(item)
    }
  }
}
object Driver extends App {
  val cache = Cache(mutable.LinkedHashSet.empty[Int], 3)
  val lru = new LRUCache()
  lru.add(cache, 1)
  lru.add(cache, 2)
  lru.add(cache, 1)
  lru.add(cache, 3)
  lru.add(cache, 1)
  lru.add(cache, 4)
  println(cache.set)

}
