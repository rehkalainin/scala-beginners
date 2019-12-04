package lectures.part8Implicit

object ImplicitEx extends App {

  // implicites
  implicit val timeout = 3000

  def setTimeOut(f: () => Unit)(implicit timeout: Int) = f()

  setTimeOut(() => println("timeout1"))

  //conversions
  // 1) implicit method

  case class Person(name: String) {
    def greet: String = {
      s"Hello my name is $name"
    }
  }

 implicit def fromStringToPerson(name: String): Person = Person(name)

  println("Valera".greet)

  // 2) implicite class
  implicit class Dog(name: String) {
    def greet1: String = {
      s"from implicit class - $name"
    }
  }

  println("Bonus".greet1)

  // implicite organization
  // local scape
  implicit val numberOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)
  val listSort = List(1, 2, 5, 3, 4).sorted
  println(listSort)

  implicit val personOrdering: Ordering[Person]= Ordering.fromLessThan((a,b)=>a.name.compareTo(b.name)<0)
  val listPerson = List(Person("Bob"),Person("Alice"),Person("Il"))

  println(listPerson.sorted)

}
