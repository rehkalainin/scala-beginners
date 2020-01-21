package exercises.ex1

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Try, Success, Failure}

object FutureSuccessAndFalse extends App {

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

  //  import cats.implicits._
  //  val separated: Future[(List[Throwable], List[String])] = listFut.traverse(_.attempt).map(_.separate)

  //  def attempt(fut: Future[String]): Future[Either[Throwable, String]] =
  //    fut.map(Right(_)).recover { case e => Left(e) }

  //  val futEithers: Future[Seq[Either[Throwable, String]]] = Future.traverse(listFut)(attempt)

  //  val sepatated: Future[(Seq[Throwable], Seq[String])] = futEithers.map { eithers =>
  ////    val errors = eithers.collect {
  ////      case Left(e) => e
  ////    }
  ////
  ////    val values = eithers.collect {
  ////      case Right(v) => v
  ////    }
  ////
  ////    errors -> values
  ////  }


  def futureToFutureTry(fut: Future[String]): Future[Try[String]] = {
    fut.map(Success(_)).recover({ case ex => Failure(ex) })
  }

  def futSeparator(listFut: Seq[Future[String]]): Future[(Seq[String], Seq[Throwable])] = {

    //    val listFutTrys: Seq[Future[Try[String]]] = listFut.map(futureToFutureTry)
    //   val futListTrys =  Future.successful(listFutTrys)

    val futListTrys: Future[Seq[Try[String]]] = Future.traverse(listFut)(futureToFutureTry)
    val separetedSeq: Future[(Seq[Try[String]], Seq[Try[String]])] = futListTrys.map(_.partition(_.isSuccess))

    for {
      values <- separetedSeq.map(_._1)
      errors <- separetedSeq.map(_._2)
    } yield {
      val strings: Seq[String] = values.collect {
        case Success(x) => x
      }
      val exceptions = errors.collect {
        case Failure(exception) => exception
      }
      (strings, exceptions)
    }
  }

  val await = Await.result(futSeparator(listFut), Duration.Inf)
  println(await)

}


