package lectures.part2oop

object Enum extends App{

  // approach 1 useing sealed trait

  sealed trait Margin{
    case object TOP extends Margin
    case object LEFT extends Margin
    case object RIGHT extends Margin
    case object BOTTON extends Margin
  }

  // approach 2 useing extends scala.Enumeration

  object Margin extends Enumeration{
    type Margin = Value
    val TOP,LEFT,RIGHT,BOTTON = Value
  }

  println(Margin.TOP)
}
