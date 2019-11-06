package exercises.ex2

object BatchadSum extends App {

  def devide(list: List[Int], batchSize: Int): Seq[List[Int]] = ???

  def sum(seq: Seq[List[Int]]): Seq[Int] = ???

  def butchadSum1(list: List[Int], size: Int, seq: Seq[List[Int]]): Seq[Int] = ???
    //devide(list,size)



//  / Дан список произвольных элементов, пусть это будет List[Int]
//    List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 ..., 100)
//         -------  -------  -------  ---------  ...
//            f1       f2       f3        f4      ...
//
//  Задача: написать функцию def batchedSum(xs: List[Int], batchSize: Int):Future[Seq[Int]]
//  которая возвращает Future с последовательностью, содержащую сумму batches, на которые данный список разбивается
//  Причем, каждый batch должен вычисляться в отдельной Future (см. f1, f2, f3, ...)
//  Каждая Future (f1, f2, ...), ответственная за вычисление своего пакета, должна выполняться строго одна за другой.
//  Тоесть в следующей последовательности:
//    f1 -> f2 -> ...> fn
//
//  Тоесть, сначала вычисляется f1, затем - f2 и т.д. Другими словами, они не должны вычисляться параллельно.
//

}
