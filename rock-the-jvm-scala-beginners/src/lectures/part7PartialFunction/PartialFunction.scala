package lectures.part7PartialFunction

import java.time.LocalDateTime

object PartialFunction extends App {

  trait MyPartialFunction [-A,+B] extends (A=>B) {
    def apply(x:A):B
    def isDefine(x:A):Boolean
  }
//  val mpf = new MyPartialFunction[Int,Int] {
//
//    override def apply(x: Int): Int = x match {
//      case 1=> 11
//      case 2 => 22
//      case n:Int => n
//    }
//    override def isDefine(x: Int): Boolean ={
//      x==1 || x==2
//    }
//  }
//  println(s"mpf: "+ mpf(1))


  val aPartialFunction: PartialFunction[Int,Int] = {
    case 1=> 11
    case 2=> 22
  } // partialFunction value

  // chat bot

  val chatbot : PartialFunction[String, String]={
    case "hello" => s"Hello master! What can I help?"
    case "time" => s"time: "+ LocalDateTime.now()
    case s:String => s
  }
//  scala.io.Source.stdin.getLines()
//    .map(chatbot)
//    .foreach(println)

  //scala.io.Source.stdin.getLines().map(chatbot).foreach(println)

 // PF utilities
// 1. isDefinedAt()
  println(aPartialFunction.isDefinedAt(5))

  // 2. lift
  val lifted = aPartialFunction.lift // A=> Option[B]
  println(aPartialFunction.lift(1))
  println(aPartialFunction.lift(5))

  // 3. pf chained
val nextPf : PartialFunction[Int,Int]= {
  case 6=>66
}
  val pfChained1 = aPartialFunction.orElse[Int, Int]{
    case 5=> 55
  }
  println(pfChained1(5))

  val pfChained2 = aPartialFunction.orElse(nextPf)
  println(pfChained2(6))

//  PF extends normal functions
  val aTotalFunction: Int=> Int ={
    case 1=> 11
    case 2=> 22
  }
  println(aPartialFunction(1))

  // HOF's accepted PF well
  val mappedList = List(1,2,3).map{
    case 1=>11
    case 2=> 22
    case n:Int=> n
  }
  println(mappedList)

}
