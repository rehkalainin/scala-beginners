package exercises.ex2

object LettersCalc extends App {

  //  val s:String = "aaabbcccdeeefgha"
  //  List(
  //    'a' -> 4,
  //    'b' -> 2,
  //    'c' -> 3,
  //  ...
  //  )
  // - решить через groupBy
  // - решить через foldLeft

  val s: String = "aaabbcccda"

  def lettersCalc1(s: String) = {
    s.toList.groupBy(identity).mapValues(_.size).toList.sortBy(_._1)
  }

  def lettersCalc2(s: String) = {
    s.toList.foldLeft(Map[Char, List[Char]]()) { (m, n) =>
      if (m.contains(n)) m + (n -> (m(n) :+ n))
      else m + (n -> List(n))

    }.mapValues(_.size).toList.sortBy(_._1)
  }

  println("lettersCalc1 " + lettersCalc1(s))
  println("lettersCalc2 " + lettersCalc2(s))

  assert(lettersCalc2(s) == List(('a' -> 4), ('b' -> 2), ('c' -> 3), ('d' -> 1)), "Faild test letterCalc2")

}
