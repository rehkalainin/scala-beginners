package lectures.part4Collections

import scala.collection.immutable.{ListSet, TreeSet}

object Set extends App{

  val trav = Traversable(1,2,3,4)
  val list = List(1,1,3,2).toSet
  val set = TreeSet(1,1,3,2)
  val listSet = ListSet(1,1,3,2)
 // val conv = TreeSet(list.toSet)

  println(list)
  println(set)
  println(listSet)


}
