package exercises.ex1

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object DayX {

  def op(n: Int) = Future {
    Thread.sleep(1000)
    n
  }

  // TODO t2 - t1 = ???
  // TODO сколько потоков
  def main( args: Array[String]) = {

    // t1
    val r = for {
      n1 <- op(5)
      n2 <- op(7)
    } yield n1 + n2
    // t2

  }

}