package exercises.ex1

import java.sql.{Connection, ResultSet, Statement}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object ConnectionProblem {

//  def withConnection[T](f: Connection => T): T =
//  {
//    var c: Connection = null
//    try {
//      c = db.getConnection
//      f(c)
//    } finally {
//      c.close()
//    }
//  }


//  def asyncOp(): Future[Any] =
//    Future {
//      withConnection { c =>  // ошибка была в том что эта строка была не во Future
//        val st = c.createStatement()
//        val rs = st.executeQuery("select count( * ) from users;")
//        (rs.next(), rs.getInt(1))
//      }
//    }
//  // TODO найти ошибку: иногда отрабатывает нормально, иногда - валится Exception
//  def main(args: Array[String]) = {
//    val f = asyncOp()
//    val r = Await.result(f, Duration.Inf)
//    println(r)
//  }
}


