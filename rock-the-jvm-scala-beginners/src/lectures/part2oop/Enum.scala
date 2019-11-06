package lectures.part2oop

import lectures.part2oop.Enum.Margin.TOP

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

  object Car extends Enumeration{
    type Car = Value
    val BMW,TOYOTA,MERSEDES = Value
  }

  println(Car.BMW)
}
