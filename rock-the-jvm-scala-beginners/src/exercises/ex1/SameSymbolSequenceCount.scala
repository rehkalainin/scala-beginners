package exercises.ex1

/**
 * Посчитать все последовательности одинаковых символов
 * Ответ выдать в виде Seq[(Char, Int)] (символ и число последовательных повторений)
 *
 * 1 functional
 * 2 val
 * 3 no recursion
 */
object SameSymbolSequenceCount extends App {

  val in = "sstriings"

  def count(s: String): Seq[(Char, Int)] = {
    s.foldLeft(Seq[(Char, Int)]()) { (seq, n) =>
      seq match {
        case Nil => seq :+ (n -> 1)
        case (char, i) :: tail if char == n => {
          (char, i + 1) :: tail
        }
        case _=> (n->1)+:seq
      }
    }.reverse
  }

  val t1 = ""
  val t2 = "sstriings"
  val t3 = "aabaa"

  println(count(t1))
  println(count(t2))
  println(count(t3))


}


