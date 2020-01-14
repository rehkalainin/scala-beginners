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

    val start = System.currentTimeMillis()
    val r = for {
      n1 <- op(5)
      n2 <- op(7)
    } yield n1 + n2
    val stop = System.currentTimeMillis()

    val totalTime = stop - start
    val await = Await.result(r, Duration.Inf)

    //    println(s"result $r, time $totalTime")
    println(s"result $await, time $totalTime")
  }
}