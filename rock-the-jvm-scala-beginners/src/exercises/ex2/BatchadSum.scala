package exercises.ex2

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object BatchadSum extends App {

  //  / Дан список произвольных элементов, пусть это будет List[Int]
  //    List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 ..., 100)
  //         -------  -------  -------  ---------  ...
  //            f1       f2       f3        f4      ...
  //
  //  Задача: написать функцию def batchedSum(xs: List[Int], batchSize: Int):Future[Seq[Int]]
  //  которая возвращает Future с последовательностью, содержащую сумму batches, на которые данный список разбивается
  //  Причем, каждый batch должен вычисляться в отдельной Future (см. f1, f2, f3, ...)
  //  Каждая Future (f1, f2, ...), ответственная за вычисление своего пакета, должна выполняться строго одна за другой.
  //  Тоесть в следующей последовательности:
  //    f1 -> f2 -> ...> fn
  //
  //  Тоесть, сначала вычисляется f1, затем - f2 и т.д. Другими словами, они не должны вычисляться параллельно.

  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)

  def devideToBach(seq: List[Int], batchadSize: Int) = {
    seq.grouped(batchadSize).toList
  }

  def futBatchSum(batch: List[Int]): Future[Int] = {
    Future {
      println(s"calculating sum of $batch")
      batch.sum
    }
  }

  def collectResult(listOfBatches: List[List[Int]]): Future[List[Int]] = {
    def helper(acc: Future[List[Int]], listOfBatches: List[List[Int]]): Future[List[Int]] = {
      if (listOfBatches.isEmpty) acc
      else {
        val newAcc = acc.flatMap{listOfSum=>
          val batch = listOfBatches.head
            futBatchSum(batch).map(sum=> listOfSum:+sum)
        }
        helper(newAcc,listOfBatches.tail)
      }
    }
    val initialAcc = Future.successful(Nil)
    helper(initialAcc, listOfBatches)
  }

  //  def collectResult(listOfBatches: List[List[Int]]): Future[List[Int]] = {
  //    //  Future.sequence(listOfBatches.map(listSum)) // параллельное вычисление всех батчей
  //
  //    def helper(acc: Future[List[Int]], remaining: List[List[Int]]): Future[List[Int]] = {
  //      if (remaining.isEmpty) acc
  //      else {
  //        val newAcc = acc.flatMap { sumList =>
  //          val batch = remaining.head
  //          listSum(batch).map(sum => sumList :+ sum)
  //        }
  //        helper(newAcc, remaining.tail)
  //      }
  //    }
  //
  //    val initialList: Future[List[Int]] = Future.successful(Nil)
  //    helper(initialList, listOfBatches)
  //  }

  val await = Await.result(collectResult(devideToBach(list, 3)), 2.second)
  println(await)

}
