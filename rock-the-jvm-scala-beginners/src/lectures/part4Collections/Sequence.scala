package lectures.part4Collections

object Sequence extends App{

  ///Seq

  val aSequence = Seq(1,2,3,4,5)
  val bSeq = aSequence ++ Seq(8,6,7)
  println(aSequence.head)
  println(aSequence.tail)
  println(aSequence)
  println(aSequence(2))
  println(0+: aSequence :+ 10)
  println(bSeq.sorted)
  val ball4 = Seq.fill(4)("ball")
  println(ball4)

/// Range

  val aRange: Seq[Int] = 1 to 10
  val alfabet: Seq[Char] = 'a' to 'z'

  aRange.foreach(println)
  alfabet.foreach(println)
  (1 to 10).foreach(x=>println("Hello"))
  ('a' to 'z').foreach(println)

  /// List

  val list = List(1,2,3,4)
  val prep = 42 +: list :+ 89

  println(list)
  println(42 :: list)
  println(prep)
  println(list(3))

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(list.head)
  println(list.tail)

  println(prep.mkString(" "))

  /// Arrays

  val arr = Array[Int](1,2,3,4)
  val arr1 = Array(1,2,3,4,5)
  val arr2 = Array.ofDim[String](3)

  arr.foreach(println)
  arr1.foreach(println)
  arr2.foreach(println)

  val number :Seq[Int] = arr
  println(number)
  println(arr1.toSeq)
  arr1(1) = 22
  println(arr1.toSeq)



}
