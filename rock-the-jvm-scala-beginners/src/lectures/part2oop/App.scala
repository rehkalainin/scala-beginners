package lectures.part2oop

import lectures.part2oop.App.User.{Id, UserAge, UserName}
import lectures.part3FunctionalAspects.PatternsEverywhere.Animal

object App extends App{

  case class User (id:Id, name:UserName, age:UserAge)
  object User {
    class Id(val value: Int) extends AnyVal
    {
      override def toString = s"Id($value)"
    }
    class UserName(val value:String) extends AnyVal
    {
      override def toString = s"UserName($value)"
    }
    class UserAge(val value:Int)extends AnyVal
    {
      override def toString = s"UserAge($value)"
    }

    def apply(id: Id, name: UserName): User = new User(id, name, new UserAge(0))

    def apply(id: Id): User = new User(id, new UserName("Noname"),new UserAge(0))
  }

  val valera = User(new Id(123),new UserName("Valera"),new UserAge(30))
  val valera2= User(new Id(124), new UserName("Valera2"))
  val valera3 = User(new Id(125))

  println(valera)
  println(valera2)
  println(valera3)

  abstract class  Animal (val name: String, val age: Int)
  case class Dog(override val name:String, override val age:Int, breed:String) extends Animal(name, age)
  case class Cat(override val name:String, override val age:Int, description: String)extends Animal(name,age)

}


