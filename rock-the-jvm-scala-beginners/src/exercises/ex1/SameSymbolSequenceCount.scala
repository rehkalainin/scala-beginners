package exercises.ex1

  object SameSymbolSequenceCount extends App {

    /**
     *  Посчитать все последовательности одинаковых символов
     *  Ответ выдать в виде Seq[(Char, Int)] (символ и число последовательных повторений)
     */

    val in = "Sstriings"




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

      def count(in: String): Seq[(Char, Int)] = in.foldLeft(Seq.empty[(Char, Int)]) {
        case (seq, currChar) => seq match {
          case Nil => Seq(currChar -> 1)
          case head :: tail => if (head._1 == currChar) {
            currChar -> (head._2 + 1) :: tail
          } else {
            (currChar -> 1) :: head :: tail
          }
        }
      }

      val t1 = ""
      val t2 = "sstriings"
      val t3 = "aabaa"

      println(count(t1))
      println(count(t2))
      println(count(t3))

    }

  }


