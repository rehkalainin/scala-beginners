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

  val list = List(1, 2, 3, 4, 5, 6)

  def squareAsync(n: Int): Future[Int] = {
    Future {
      println(s"calc square $n")
      n * n
    }
  }

  def factAsync(n: Int): Future[Int] = {
    def helper(acc: Int, remaining: Int): Int = {
      if (remaining <= 1) {
        println(s"calc fact $n")
        acc
      }
      else helper(acc * remaining, remaining - 1)
    }

    Future {
      helper(1, n)
    }

  }

  def colectAsyncResult(list: List[Int], f: Int => Future[Int]) = {
    list.map(n => f(n))
  }

  def colectResult(colectAsyncResult: List[Future[Int]]) = {
     Future.sequence(colectAsyncResult)
//    def helper(acc: Future[List[Int]], remaining: List[Future[Int]]): Future[List[Int]] = {
//      if (remaining.isEmpty) acc
//      else {
//        val newAcc = remaining.head.flatMap { res =>
//          acc.map { listRes => listRes :+ res }
//        }
//        helper(newAcc, remaining.tail)
//      }
//    }
//    helper(Future.successful(Nil), colectAsyncResult)
  }

  val await1 = Await.result(colectResult(colectAsyncResult(list, squareAsync)),1.second)
  val await2 = Await.result(colectResult(colectAsyncResult(list, factAsync)),1.second)
  println(await1)
  println(await2)
}
