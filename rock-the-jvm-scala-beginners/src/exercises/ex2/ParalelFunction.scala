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

  def squareAsync(n:Int):Future[Int] = Future(n*n)

  def factorialAsync (n:Int):Future[Int]= {
    def helper(x:Int, acc:Int):Int={
      if (x<=1) acc
      else helper(x-1, acc*x)
    }
    Future(helper(n,1))
  }
 // Future.sequence(Seq(a, b, c))

  def listFutures(list:List[Int], f: Int=>Future[Int])={
    list.map(x=>f(x))
  }

  def collectResult (listFutures: List[Future[Int]]): Future[List[Int]]={
    def helper(acc: Future[List[Int]], remaining: List[Future[Int]]):Future[List[Int]]={
      if(remaining.isEmpty) acc
      else {
        val newAcc = acc.flatMap(li=> remaining.head.map(i=> li:+i))
        helper(newAcc, remaining.tail)
      }
    }
    val initialList : Future[List[Int]] = Future.successful(Nil)
    helper(initialList, listFutures)
  }

    val aw: List[Int] = Await.result(collectResult(listFutures(list,squareAsync)), 2.second)
    println(aw)
    println(Await.result(collectResult(listFutures(list,factorialAsync)),2 second) )
    println("____________________________________")

}
