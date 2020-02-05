package exercises

object CheckDay extends App {
  /*

    Дана последовательность val in = Seq(1, 2, 3, -1, -2, 1, -1, -2, -3)
    нужно посчитать количество положительных и отрицательных последовательностей
    которых больше 3

     */

  val in = Seq(1, 2, 3, -1, -2, 1, -1, -2, -3)

  val res1 = in.foldLeft((0, 0, 0)) { (accumSeq, an) =>
    accumSeq match {
      case (a1, a2, counter) if a1 >= 3 || a2 >= 3 => (1, 1, counter + 1)
      case (a1, a2, counter) if an < 0 && a1 < 3 => (a1 + 1, a2, counter)
      case (a1, a2, counter) if an > 0 && a2 < 3 => (a1, a2 + 1, counter)

    }
  }
  println(res1)

}


