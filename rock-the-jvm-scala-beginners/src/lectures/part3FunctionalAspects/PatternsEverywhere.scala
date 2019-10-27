package lectures.part3FunctionalAspects

object PatternsEverywhere extends App{

  // 1 - big idea
  try{
    ///code
  } catch {
      case e: RuntimeException => "runtime"
      case npe: NullPointerException => "npe"
      case _ => "something else"
    }

  /// 2 - big idea

  val list = List(1,2,3,4,5,6)
  val evenOnes = for {
      x<-list if x%2==0
  }yield x*10
  println(evenOnes)

  /// generator also baser on PM
  val tuples = List ((1,2),(3,4))
  val filterTuples = for {
    (first, second) <-tuples
  }yield (first*10, second)

  println(filterTuples)

  /// big idea 4
 // multiple values definition based on PM
  val tuple = (1,2,3)
  val (a,b,c)= tuple
  println(b)

  val head::tail = List(1,2,3,4,5,6)

  println(head)
  println(tail)

  //big idea 5
  // partial function
  val mapedList = list.map(x=> x match {
    case n if n%2==0 => n+ " is Even"
    case 1 => " one"
    case _ => "something else"
  })
println(mapedList)

  // match using unapply
  class Person (val name: String, val age: Int)
  object Person{
    def unapply(person: Person): Option[(String, Int)] = Some((person.name, person.age))
  }
val aPerson = new Person("Valera", 27)
  aPerson match {
    case Person (name, _)=> println(s"My name is $name")
  }

  // match without unapply because use case class
  case class Animal (val name:String, val age:Int)

  val anAnimal = new Animal("Bobby", 2)

  def greeting (animal: Animal):String=animal match{
    case Animal(_, age) if age>0 && age<3=> s"Yang animal"
    case Animal(_, age) if age>=3=> s"adult animal"
  }
  println(greeting(anAnimal))
}
