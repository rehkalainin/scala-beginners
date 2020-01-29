package exercises.ex1

object NumberCounterSeqAll extends App {

  /*

  Дана последовательность val in = Seq(1, 2, 3, -1, -2, 1, -1, -2, -3)
  нужно посчетать количество положительных и отрицательных последовательностей
  которых больше 3

   */

  val in = Seq(1, 2, 3, -1, -2, 1, -1, -2, -3)

  def seqCounter(in: Seq[Int]) = {
    in.foldLeft((0, 0, false)) { (tup, n) =>
      tup match {
        case (0, 0, _) if n > 0 => (1, 0, true)
        case (0, 0, _) if n < 0 => (1, 0, false)
        case (2, counter, true) if n > 0 => (3, counter + 1, true)
        case (2, counter, false) if n < 0 => (3, counter + 1, false)
        case (inc, counter, true) if n > 0 => (inc + 1, counter, true)
        case (inc, counter, false) if n < 0 => (inc + 1, counter, false)
        case (_, counter, _) if n > 0 => (1, counter, true)
        case (_, counter, _) if n < 0 => (1, counter, false)
      }
      //        case Nil if n > 0 => seq :+ (1, 0, true)
      //        case Nil if n < 0 => seq :+ (1, 0, false)
      //        case (2, counter, true) :: tail if n > 0 == seq.head._3 => seq :+ (3, counter + 1, true)
      //        case (2, counter, false) :: tail if n < 0 == seq.head._3 => seq :+ (3, counter + 1, false)
      //        case head :: tail if n > 0 == head._3 => seq :+ (head._1 + 1, head._2, true)
      //        case head :: tail if n < 0 == head._3 => seq :+ (head._1 + 1, head._2, false)
      //        case head :: tail if n > 0 != head._3 => seq :+ (0, head._2, true)
      //        case head :: tail if n < 0 != head._3 => seq :+ (0, head._2, false)
      //      }
    }
  }

  val res = seqCounter(in)

  println(s"tuple $res ,  answer - ${res._2} ")

  //  def compact(s: Seq[Int], agg: Seq[Int]): Seq[Int] = {
  //    s match {
  //      case Nil => agg
  //      case x :: _ =>
  //        val (l, r) = s.span(_ * x > 0)
  //        compact(r, agg :+ l.size)
  //    }
  //  }
  //
  //  compact(in, Seq.empty).count(_ >= 3)

}
