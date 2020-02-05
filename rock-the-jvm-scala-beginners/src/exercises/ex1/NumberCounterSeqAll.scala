package exercises.ex1

object NumberCounterSeqAll extends App {

  /*
  Дана последовательность val in = Seq(1, 2, 3, -1, -2, 1, -1, -2, -3)
  нужно посчитать количество положительных и отрицательных последовательностей
  которых больше 3
   */

  val in = Seq(1, 2, 3, -1, -2, -3)

  def seqCounter(in: Seq[Int]) = {
    in.foldLeft((0, 0, false)) { (tup, n) =>
      if (n > 0) {
        tup match {
          case (2, counter, true) => (3, counter + 1, true)
          case (inc, counter, true) => (inc + 1, counter, true)
          case (_, counter, false) => (1, counter, true)
        }
      } else {
        tup match {
          case (2, counter, false) => (3, counter + 1, false)
          case (inc, counter, false) => (inc + 1, counter, false)
          case (_, counter, true) => (1, counter, false)
        }
      }
    }
  }

  val res = seqCounter(in)

  println(s"tuple $res ,  answer - ${res._2} ")

}
