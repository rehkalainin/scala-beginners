package exercises.ex1

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object DayX {

  def op(n: Int) = Future {
    Thread.sleep(2000)
    println(Thread.activeCount())
    n
  }

  // TODO t2 - t1 = ???
  // TODO сколько потоков
  def main(args: Array[String]) = {

    val t1 = System.currentTimeMillis()
    val r: Future[Int] = for {
      n1 <- op(5)
      n2 <- op(7)
    } yield n1 + n2


    val await = Await.result(r, Duration.Inf)
    val t2 = System.currentTimeMillis()
    val totalTime = t2 - t1
    //    println(s"result $r, time $totalTime")
    println(s"result $await, time $totalTime")
  }
}