package exercises.ex2

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object ButchadSumConsistently extends App {

  /**
   * Написать функцию `batchedFutures`, которая применит заданную функцию `f` к каждому элементу коллекции.
   * При этом, необходимо вычислить все получившиеся футуры (Futures) не все сразу параллельно, а пакетами с заданным размером `batchSize`.
   * Функция `batchedFutures` должна возвратить футуру со списком результатов применения ф-ции `f` к каждому из элементов.
   *
   * Пример:
   * {{{
   *     val xs = List(1,  2,  3,  4,  5,  6,  7,  8,  9,  ..., 100)
   *
   *                   |   |   |   |   |   |   |   |   |               //#1: применение ф-ции `f` к каждому элементу списка
   *                   v   v   v   v   v   v   v   v   v   ...
   *                   f1  f2  f3  f4  f5  f6  f7  f8  f9              //#2: асинхронные результаты применения ф-ции `f` к каждому элементу списка
   *                   _________  _________  __________
   *                     batch1      batch2      batch3                //#3: разбиение футур на пакеты заданного размера `batchSize=3`
   *
   *     batchedFutures(xs, batchSize = 3, (e:Int) => Future(-e))      //#4: передаем ф-цию, которая инвертирует знак элемента
   *      |
   *      |
   *      +---> должен вернуть Future[List[-1, -2, -3, ..., -100]]     //#5: результирующий список отрицательных элементов, вычисленный пакетами
   *
   * }}}
   *
   * Например, в примере выше, размер `batchSize=3`. Это значит, что футуры `f1`, `f2`, `f3`, ..., `fn` будут вычисляться пакетами:
   * 1. сначала параллельно вычислятся футуры первого пакета: `f1, f2, f3`
   * 2. затем параллельно вычислятся футуры второго пакета: `f4, f5, f6`
   * 3. и т.д., пока не вычислится последний пакет футур
   *
   * Необходимо проиллюстрировать, что футуры действительно выполняются параллельно в пределах пакета.
   * Продемонстрировать работу программы для разных batchSize: 1, 2, 4, 8, 10, 20
   *
   * //   * @param l         - входной список
   * //   * @param batchSize - размер пакета футур
   * //   * @param f         - функция, которая должна применяться к каждому элементу входного списка `l`
   * //   */

  val l = (1 to 100).toList

  def batchedFutures(l: List[Int], batchSize: Int, f: Int => Future[Int]): Future[List[Int]] = ???

  def invert(e: Int): Future[Int] = {
    Future {
      println(s" invert $e")
      -e
    }
  }

  def listofBached(l: List[Int], batchSize: Int) = {
    l.grouped(batchSize).toList
  }


//  val await = Await.result(collectResAsync(listofBached(l, 3)), 2.second)
//  println(await)

}
