package lectures.part2oop

import lectures.part2oop.CompanionObject.Human.{Age, LastName, Name}
import lectures.part2oop.Enum.Margin

object CompanionObject extends App{

  // good practice use value classes

  class Human (name:Name, lastName:LastName, age:Age)
  object Human {
    class Name (val value:String) extends AnyVal{

      override def toString = s"Name($value)"
    }
    class LastName (val value: String) extends AnyVal{

      override def toString = s"Mr/Ms $value"
    }
   class Age (val value:Int) extends AnyVal{

     override def toString = s"Age($value)"
   }
  def apply (name: Name, lastName: LastName): Human = new Human(name, lastName, new Age(0))
  def apply (name: Name):Human = new Human(name, new LastName("Noname"),new Age(0))

  }

  println(new Human( new Name("Bob"), new LastName("Black"), new Age(25)))
  println(Human( new Name("Bob"), new LastName("Black")))
  println(Human( new Name("Bob")))
}
