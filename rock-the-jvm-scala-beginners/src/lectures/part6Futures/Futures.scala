package lectures.part6Futures
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Futures extends App {

  val fut: Future[Int]= Future{
    Thread.sleep(1000)
    21+21}
  val res = fut.map(x=> x+1)

Thread.sleep(2000)
  println(fut.isCompleted) // true
  println(fut.value) // Some(Success(42))
  println(fut) // Future(Success(42))
  println(res) // Future(Success(43))
//
  def miningOfLife:Int={
    Thread.sleep(1000)
    90
  }
  val aFuture = Future{
    miningOfLife
  }
  println(aFuture.value)
  println("Waiting on the future...")
  aFuture.onComplete {
    case Success(miningOfLife) =>println(s"Mining of Life is $miningOfLife")
    case Failure(e) => (s"I have failed with $e")
  }


  Thread.sleep(2000)

  // Promise

  val pro = Promise[Int]
  val fut1 = pro.future

  println(fut1.value)
  println(fut1.isCompleted)

  pro.success(54)
  println(pro)
  println(fut1.value)
  println(fut1.isCompleted)

// 1. fulFill Immediately

  def fulFillImmediately[Int](value:Int):Future[Int]=
    Future{value}

  println(fulFillImmediately(12))

//2. inSequence (fa, fb)

  def inSequence[Int, String] (first: Future[Int], second: Future[String] ):Future[String]={
    first.flatMap(f1=>second)
  }
  val await1 = Await.result(inSequence(Future(65+65),Future("Text")),2.second)
  println(await1)

  // 3. first out of two futures
  def first[Int](fa:Future[Int], fb:Future[Int]):Future[Int]={
    val listFut : List[Future[Int]] = List()

   Future.firstCompletedOf(listFut)

//    val promise = Promise[Int]
//
//    fa.onComplete(promise.tryComplete)
//    fb.onComplete(promise.tryComplete)
//
//    promise.future
  }


 //println(Await.result(first(Future{2+2+2+2},Future{3+3}),2.second))
}
