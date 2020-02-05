package exercises.ex1

import scala.util.matching.{Regex, UnanchoredRegex}

object NameEmailRegex extends App {

  val input = "oleg oleg@email.com\n7bdaf0a1be3\na8af118b1a2\n28d74b7a3fe"
  val input2 = "oleg\noleg@email.com\n7bdaf0a1be3\na8af118b1a2\n28d74b7a3fe"

  val regexNameEmail: Regex = "(\\w+)\\s+(\\w+@\\w+.\\w+)".r

  val nameSpaceEmail: UnanchoredRegex = regexNameEmail.unanchored // вытаскивание этого совпадения по regex
  val regexDomen = "(?<=@)\\w+.\\w+".r // найти все после @, но @ не выводить (позитивный просмотр назад)

  val result = input match {
    case nameSpaceEmail(name, email) => s"$name ${
      regexDomen.findFirstIn(email) match {
        case None =>"invalid domen"
        case Some(value) =>s"$value"
      }}"
    case _ => "invalid"
  }

  println(result)

}
