package exercises.ex1

import exercises.ex2.SuccessAndFalseSeparator.futureToTry

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

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

  def futureToFutureTry(fut: Future[String]): Future[Try[String]] = {
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

  val await = Await.result(separator(listFut), Duration.Inf)
  println(await)

  //    import cats.implicits._
  //    val separated: Future[(List[Throwable], List[String])] = listFut.traverse(_.attempt).map(_.separate)

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



  //  def futSeparator(listFut: Seq[Future[String]]): Future[(Seq[String], Seq[Throwable])] = {
  //
  //    val futTrys: Future[Seq[Try[String]]] = Future.traverse(listFut)(futureToFutureTry)
  //    val separetedSeq: Future[(Seq[Try[String]], Seq[Try[String]])] = futTrys.map(_.partition(_.isSuccess))
  //
  //    for {
  //      values <- separetedSeq.map(_._1)
  //      errors <- separetedSeq.map(_._2)
  //    } yield {
  //      val strings: Seq[String] = values.collect {
  //        case Success(x) => x
  //      }
  //      val exceptions = errors.collect {
  //        case Failure(exception) => exception
  //      }
  //      (strings, exceptions)
  //    }
  //  }

}


