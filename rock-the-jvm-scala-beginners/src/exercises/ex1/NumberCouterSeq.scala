package exercises.ex1

object NumberCouterSeq extends App {
  /*
  Посчитать количество последовательностей  из отрицательных чисел не менее 3
  например -2,-3,-4 это одна последовательность = каунтер 1
  -2, -2, -1 - это вторая последовательность = каунтер 2
   */

  val list = List(1, -2, -3, -4, -1, 3, 1, -2, -2, -1, 0, -1, -1, -2)
  val list2 = List(1, -2, -3, -4, -1)
  val list3 = List(1, -2, -3, -4, -1, 3, 1, -2, -2, -1)


  val res = list3.foldLeft((0, 0)) { (tup, n) =>
    if (n < 0) {
      tup match {
        case (2, counter) => (3, counter + 1)
        case (seq, counter) => (seq + 1, counter)
      }
    } else (0, tup._2)

    //    if (n < 0) {
    //      val seq = tup._1 + 1
    //      if (seq == 3) {
    //        val counter = tup._2 + 1
    //        (seq, counter)
    //      } else (seq, tup._2)
    //    } else (0, tup._2)
    //
    //  }

  }
  println(res)

}
