package lectures.part5Monads

object Options extends App {

  sealed abstract class Option[+A]
  class Some[+A](x:A)extends Option[A]
  object None extends Option[Nothing]

  val mapString = Map("key1"->"value1", "key2"->"value2","key3"->"value3")
  val list = List(1,2,23,4,7,5,6)

  // методы которые выкидывают Option[]

  println("get " + mapString.get("key1")) // Some(value1)
  println( mapString("key1")) // value1
  println("map "+ mapString.get("key")) // None

  println("headOption " + list.headOption) // Some(1)
  println("find " + list.find(_%5==0).getOrElse(list.find(_%2==0))) // находит первый попавшийся элемент по предикату Some(2)


}
