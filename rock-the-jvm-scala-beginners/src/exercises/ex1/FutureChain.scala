package exercises.ex1

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object FutureChain extends App {


  val list = (1 to 10).toList

  def f(): Future[Int] = {
    Future {
      5
    }
  }

  def f1(e: Int): Future[Int] = {
    Future {
      e * 10
    }
  }

  def f2(e: Int): Future[Int] = {
    Future {
      -e
    }
  }

  // Simple level 1 - chain f and f1

  //  val res = f().flatMap(f2)

  //  val r: Future[Int] = f()
  //  val res1: Future[Int] = for {
  //    a: Int <- r
  //    res: Int <- f2(a)
  //  } yield res


  // level 2 - chain f1 and f2 on list

  val listFut: List[Future[Int]] = list.map(f1)
  val futRes1: Future[List[Int]] = Future.sequence(listFut)

  val listFut2 = futRes1.flatMap(list => Future.traverse(list)(f2))

//  for{
//    res1: List[Int] <- futRes1
//    futRes2: Future[Int] <- res1.map(f2)
//  } yield futRes2

  //  val await = Await.result(res, Duration.Inf)
  //  println(await)
}
