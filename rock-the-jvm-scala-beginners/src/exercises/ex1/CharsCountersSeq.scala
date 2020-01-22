package exercises.ex1

/**
 * Посчитать все последовательности одинаковых символов
 * Ответ выдать в виде Seq[(Char, Int)] (символ и число последовательных повторений)
 *
 * 1 functional
 * 2 val
 * 3 no recursion
 */
object CharsCountersSeq extends App {

  val in = "sstriings"

  def count(str: String): Seq[(Char, Int)] = {
    str.foldLeft(Seq[(Char, Int)]()) { (seq, n) =>
      seq match {
        case (`n`, i) :: tail => (n, i + 1) :: tail
        // или так  case (char, i) :: tail if char == n => (char, i + 1) :: tail
        case _ => (n -> 1) +: seq
      }

    }.reverse
  }

  val t1 = ""
  val t2 = "sstriings"
  val t3 = "aabaa"

  println(count(t1))
  println(count(t2))
  println(count(t3))

  /////////////////////////////////////////////////////

  val s: String = "aaabbcccdeeefgha"

  //  List(
  //    'a' -> 4,
  //    'b' -> 2,
  //    'c' -> 3,
  //  ...
  //  )
  // - решить через groupBy
  // - решить через foldLeft

  def calcSum(str: String): List[(Char, Int)] = {
    str.foldLeft(Map[Char, Int]()) { (map, c) =>
      if (map.contains(c)) map + (c -> (map(c) + 1))
      else map + (c -> 1)
    }.toList.sortBy(_._1)
  }

  def calcByGroupeBy(str: String): List[(Char, Int)] = {
    str.groupBy(identity).mapValues(_.size).toList.sortBy(_._1)
  }

  println(s"calcSum: ${calcSum(t1)}")
  println(s"calcSum: ${calcSum(t2)}")
  println(s"calcSum: ${calcSum(t3)}")
  println(s"calcSum: ${calcSum(s)}")
  println(s"calcByGroupeBy: ${calcByGroupeBy(s)}")
  println(s"calcByGroupeBy: ${calcByGroupeBy(t2)}")
}


