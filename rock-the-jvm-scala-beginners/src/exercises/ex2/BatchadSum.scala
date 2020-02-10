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

  val list = (1 to 100).toList

  def batchSum(batch: List[Int]): Future[Int] = {
    Future {
      Thread.sleep(3000)
      val sum = batch.sum
      println(s"compute batchSum of batch $batch : $sum")
      sum
    }
  }

  def batchedSum(xs: List[Int], batchSize: Int): Future[List[Int]] = {
    val batches: List[List[Int]] = xs.grouped(batchSize).toList

    /////// paralel computetion

    //        val listFut: List[Future[Int]] = batches.map(batchSum)
    //        Future.sequence(listFut)

    /////////// sequence computetion by 1 Thread

    batches.foldLeft(Future.successful(List.empty[Int])) { (accFut, batch) =>
      for {
        accRes: List[Int] <- accFut
        res <- batchSum(batch)
      } yield accRes :+ res
    }

  }

  val await = Await.result(batchedSum(list, 5), Duration.Inf)
  println(await)
}