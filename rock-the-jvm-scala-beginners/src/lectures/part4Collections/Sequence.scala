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

  aRange.foreach(println)
  (1 to 10).foreach(x=>println("Hello"))

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

  /// List

  val list = List(1,2,3,4)
  val prep = 42 +: list :+ 89
  val collection = List (1,3,5,7,8,9,2,4,5)

  println(list)
  println(42 :: list)
  println(prep)
  println(list(3))

  val apples5 = List.fill(5)("apple")
  println("fill "+apples5)
  println("List head "+list.head)
  println("List tail "+list.tail)

  println(prep.mkString(" "))

  // reduce = бинарная функция, которая объединяет параметры для получения 1 значения
  println("reduce max "+collection.reduce((x,y)=>x max y))// возвращает 1 значение
  println("reduce min "+collection.reduce(_ min _))
  println("scan "+collection.scan(0)(_ + _)) // возвращает измененную колекцию
  println("fold "+collection.fold(0)(_ + _))

  // унарные операции map, flatMap, zip
println("map "+collection.map(x=> x+100))
println("flatMap "+ collection.flatMap(x=> List(x,x+100,x+1000)))

  // унарные с предикатом

  println("partition "+collection.partition(x=> x%2==0))
  println("filter "+ collection.filter(x=> x%2==0))
}
