package lectures.part2oop

import lectures.part3FunctionalAspects.PatternMatching.Person

object Enheritanse extends App {

  // constructor
  case class Person (name:String, age:Int){
    val marriagStatus = "single"
    // def this(name: String) = this (name, 0) - плохая практика так деласть конструктор, лучше через Companion object
    def greeting = println(s"Hello, my name is $name, I am $age years old")
  }

  object Person {
     def apply(name:String): Person = Person(name,0) // обращаемся к case class
   }

  class Adult (name:String, age:Int, idCard:Int) extends Person(name,age){
    override val marriagStatus: String = "marriage"

    override def greeting: Unit = println(s"Hello, my name is $name, I am $age years old, my idCard: $idCard")
    def greeting (n:Int): String = s"Hello, your n is $n"
  }


  println( Person("Valera")) // обращаемся к object Person
  println( Person("Valera",1)) // обращаемся к case class Person
  println( new Adult("Ira", 2,111))
  val jim = new Adult("Jim", 27,121212)
  jim.greeting
  println(jim.marriagStatus)

  val user :Person = new Adult("Bob", 25, 99199199) // polymorfism

  println(user)
  user.greeting
}
