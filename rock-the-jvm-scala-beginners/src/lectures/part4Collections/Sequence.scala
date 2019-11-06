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
  val charList = List('a','b','c','d','e')
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
  println("list(0) "+ list(0)) // возвращает Элемент под номером 0 - 1
  println("list.take(2) "+ list.take(2)) // возвращает List с элементами до индекса 2 - List(1,2)
  println("list.drop(2) "+ list.drop(2)) // возвращает List с элементами после индекса 2 - List(3,4)
  println("list.splitAt(2) "+ list.splitAt(2)) // разбивает список по заданному индексу на 2 списка и возвращ. кортеж (List(1,2), List(3,4))
  println("indeces" + list.indices )// возвращает Range 0 until 4

  println("flatten " + List(List(1,2),List(3), List(),List(4,5)).flatten ) // работает только на списке списков, линеаризирует в единый список
  val ziped = list.zip(charList)
  println("zip "+ list.zip(charList)) // из 2х списков делает List картежей List((1,a),(2,b),(3,c),(4,d)), не парные обрезает
  println("zip "+ charList.indices.zip(charList))// возвращает Vector, объединение списка в пару с его индексами элементов
  println("unzip "+ ziped.unzip) // из списка картежей возвращает обратно 2 списка

  println(prep.mkString(" "))// выводит с разделением каждого элемента пробелом
  println("mkString "+ list.mkString("[",",","]"))// [1,2,3,4]

  // reduce = бинарная функция, которая объединяет параметры для получения 1 значения
  println("reduce max "+collection.reduce((x,y)=>x max y))// возвращает 1 значение
  println("reduce min "+collection.reduce(_ min _))
  println("scan "+collection.scan(0)(_ + _)) // возвращает измененную колекцию
  println("fold "+collection.fold(0)(_ + _))

  // методы высшего порядка map, flatMap
println("map "+collection.map(x=> x+100))
println("flatMap "+ collection.flatMap(x=> List(x,x+100,x+1000)))
  val words = List("the","quick", "brown", "fox")
  println("map "+ words.map(x=>x.toList))
  println("flatmap "+ words.flatMap(x=>x.toList))

  val aList = List(1,2,3,4,5,6,7)
  val result = aList.map(x=>
  if(x%2==0) x
  else -x)

  println(result)

  // унарные с предикатом

  println("partition "+collection.partition(x=> x%2==0)) // возвращает отфильтрованный и оставшийся листы
  println("filter "+ collection.filter(x=> x%2==0)) // возвращает отфильтрованный лист
}
