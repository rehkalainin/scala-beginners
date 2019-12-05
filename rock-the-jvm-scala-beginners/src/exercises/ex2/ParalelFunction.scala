package exercises.ex2

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object ParalelFunction extends App {

//  Написать ф-цию, параллельно вычисляющую некоторую функцию применительно к каждому элементу списка:
  ////
  ////    List(1,2,3,4,5,6)
  ////
  ////  примеры:
  ////    1) параллельно посчитать квадрат:
  ////    f = x^2
  ////  result = List(1, 4, 9, 16, ...)
  ////
  ////  2) параллельно посчитать факториал:
  ////    f = x!
  ////    result = List(1, 2, 6, 24, 120, ...)

 // def squareAsync(n: Int): Future[Int] = ???

 // def collectResults(futures: List[Future[Int]]): Future[List[Int]]

  val list = List(1,2,3,4,5,6)

  def factAsync (n:Int):Future[Int]={
    def helper (acc: Int, remaining: Int):Int={
      if(remaining<=1) acc
      else helper(acc*remaining, remaining-1)
    }
   Future(helper(1, n))

  }
  def squreAsync(n:Int):Future[Int]={
    Future{
      println(s"culc square $n")
      n*n}
  }
  def collectFut(list:List[Int], f:Int=>Future[Int]):List[Future[Int]]={
    list.map(x=> f(x))
  }
  def collectRes(listFut: List[Future[Int]]):Future[List[Int]]={
  //Future.sequence(listFut)
    def helper (acc: Future[List[Int]], remaining: List[Future[Int]]):Future[List[Int]]={
      if (remaining.isEmpty)acc
      else {
        val newAcc = acc.flatMap(listRes=> remaining.head.map(res=> listRes:+res))
        helper(newAcc, remaining.tail)
      }
    }
    val initial = Future.successful(Nil)
    helper(initial, listFut)
  }

 val await = Await.result(collectRes(collectFut(list,squreAsync)),2.second)
  println(await)
}
