package exercises.ex1

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object FutureChain extends App {


  val list = (1 to 10).toList

  def f1(e: Int): Future[Int] = {
    Future {
      Thread.sleep(2000)
      println(s"calc f1 : el $e")
      e * 11
    }
  }

  def f2(e: Int): Future[Int] = {
    Future {
      Thread.sleep(2000)
      println(s"calc f2 : el $e")
      -e
    }
  }

  // chain f1 and f2 on list
  def calc(l: List[Int], f1: Int => Future[Int], f2: Int => Future[Int]): Future[List[Int]] = {

    val listFut: List[Future[Int]] = list.map(f1)
    val futRes1: Future[List[Int]] = Future.sequence(listFut).recoverWith { case e: ArithmeticException => Future {
      List.empty[Int]
    }
    } // parallel calc

    for {
      listRes1: List[Int] <- futRes1
      listRes2: List[Int] <- Future.traverse(listRes1)(f2) // sequenc calc

    } yield listRes2

  }

  val await = Await.result(calc(list, f1, f2), Duration.Inf)
  println(await)
}
