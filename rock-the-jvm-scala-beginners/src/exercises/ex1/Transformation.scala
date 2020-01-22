package exercises.ex1

object Transformation extends App {

  /**
   * Transformation Chain
   * Дан набор возможных трансформаций: type Transformation[T] = T => Option[T]
   * Написать функцию преобразования последовательности трансформаций в возможную трансформацию.
   * Новая трансформация это результат работы всей цепочки трансформаций, которые не вернули None.
   * Если все вернули None, то общий результат None.
   */

  type Transformation[Int] = Int => Option[Int]

  def transformationChain[Int](chain: Seq[Transformation[Int]]): Transformation[Int] = in => {

    val res: (Int, Boolean) = chain.foldLeft((in, false))((acc: Tuple2[Int, Boolean], f) => {
      f(acc._1) match {
        case Some(v) => (v, true)
        case None => acc
      }
    })

    if (res._2) Some(res._1) else None

  }


  val t1: Transformation[Int] = t => Some(t + t)
  val t2: Transformation[Int] = _ => None
  val t3: Transformation[Int] = t => if (t > 2) Some(t * t) else None

  val tc = transformationChain(Seq(t1, t2, t3))

  println(tc(2))
}
