package exercises

import scala.collection.immutable
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object CheckDay extends App {

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

  val list = (1 to 20).toList

  def futSum(batch: List[Int]): Future[Int] = {
    Future {
      Thread.sleep(2000)
      println(s"calc batch sum $batch")
      batch.sum
    }
  }

  def batchedSum(xs: List[Int], batchSize: Int): Future[List[Int]] = {
    val listBatch: List[List[Int]] = xs.grouped(batchSize).toList
    listBatch.foldLeft(Future.successful(List.empty[Int])) { (accFut, batch) =>
      for {
        accRes <- accFut
        res <- futSum(batch)
      } yield accRes :+ res
    }


  }

  val await = Await.result(batchedSum(list, 3), Duration.Inf)
  println(await)
}


