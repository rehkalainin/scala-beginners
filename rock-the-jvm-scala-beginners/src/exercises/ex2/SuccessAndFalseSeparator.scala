package exercises.ex2

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object SuccessAndFalseSeparator extends App {


  /*    На вход Seq[Future[String]]
    *     Получить Future[(Seq[String], Seq[Throwable]) - результат агрегации выполненых Future и исключений
    */

  val listFut = List(
    Future.successful("Connection1"),
    Future.successful("Connection2"),
    Future.failed(new RuntimeException),
    Future.failed(new RuntimeException),
    Future.failed(new RuntimeException),
    Future.successful("Connection3"),
  )

  def futureToTry(fut: Future[String]): Future[Try[String]] = {
    fut.map(Success(_)).recover {
      case ex => Failure(ex)
    }
  }

  def separator(listFut: Seq[Future[String]]): Future[(Seq[String], Seq[Throwable])] = {
    val futTrys: Future[Seq[Try[String]]] = Future.traverse(listFut)(futureToTry)

    futTrys.map { tryes: Seq[Try[String]] =>

      val values = tryes.collect {
        case Success(value) => value
      }

      val errors = tryes.collect {
        case Failure(exception) => exception
      }
      (values, errors)
    }
  }

  val await = Await.result(separator(listFut),Duration.Inf)
  println(await)
}
