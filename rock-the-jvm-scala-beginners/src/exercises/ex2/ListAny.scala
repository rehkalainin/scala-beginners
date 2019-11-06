package exercises.ex2

object ListAny extends App{

  val xs:List[Any] = List("ads","sa")

  xs match {
    case i:List[Int]=>println("numbers")
    case i:List[String]=>println("String")
    case _=>println("unknown")
   }

  val xy:Any = 12.6

  xy match {
    case i:Int=>println("namber")
    case i: String=>println("String")
    case _=>println("unknown")
  }

}
