package lectures.part3FunctionalAspects

import lectures.part3FunctionalAspects.PatternMatching

import scala.util.Random

object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "One"
    case 2 => "Twice"
    case 3 => "Three"
    case _ => "Something else"
  }

  println(x)
  println(description)

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 21)
  val nik = Person("Nik", 15)
  val valera = Person("Valera", 10)

  def greeting(person: Person) = person match {
    case Person(n, a) if a >= 21 => s"Hello , my name is $n and I am Adult"
    case Person(n, a) if a >= 14 => s"Hello , my name is $n and I am Teenager"
    case Person(n, a) if a > 0 => s"Hello , my name is $n and I am Chaild"
    case _ => "I  don't know who I am"
  }

  println(greeting(bob))
  println(greeting(valera))
  println(greeting(nik))

  sealed abstract class Device

  case class Phone(model: String, price: Int) extends Device

  case class Computer(model: String, price: Int) extends Device

  case object Toster extends Device

  def showDevice(d: Device): String = d match {

    case p: Phone if p.price <= 15000 => s"It's $p cheap phone"
    case Phone(model, price) if price > 15000 => s"It's $model exspensive phone"
    case _: Phone => s"It's a phone, was matched by type"
    case Computer(_, 25000) => s"It's a computer cost 25 000"
    case Computer(_, pr) => s"It's a computer cost $pr"
    case _: Computer => s"It's a computer"
    case Toster => s"It's a toster"


  }

  println(showDevice(new Phone("Apple7", 12000)))
  println(showDevice(new Phone("Apple10", 20000)))
  println(showDevice(new Phone("Sumsung", 9000)))
  println(showDevice(new Computer("HP", 25000)))
  println(showDevice(new Computer("HP2", 27000)))
  println(showDevice(Toster))

//////////////////////////////////
  def wether(w: String): Any = w match {
    case "rainy" => s"pick up umbrela "
    case "sunny" => s"dress a cap"
    case "windy" => 22
    case _ => s"go nude"
  }

  println(wether("sunny"))
  println(wether("sun"))
  println(wether("windy"))

/////////////////////////////////////////////
  trait Expr

  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show (e:Expr):String= e match {

    case Number(n)=>s"$n"
    case Sum(e1, e2)=> show(e1) + " + "+ show(e2)
    case _ => "will try my best"

  }
  println(show(Number(5)))
  println(show(Sum(Number(3),Number(7))))
  println(show(Sum(Number(3),Number(7))))

  ///////most common case//////////////////////////////////

  def describe(x:Any) = x match {
    case 1 => "one"
    case true => "true"
    case "hello" => "hi!"
    case Nil => "Empty list"
    case _ => "something else"
  }
  println(describe("hello"))
  println(describe(1))
  println(describe(2))


  ////////////

  sealed trait PersonW

  case class User (name:String, lastname:String) extends PersonW
  case class Admin (name:String, lastname:String) extends PersonW

  def getPerson(p:PersonW):String = p match {

    case User(_,_) =>s"User constructor"
    case _: User =>s"User type"
    case _: Admin =>s"Admin type"
    case Admin(_,_) =>s"Admin constructor"

  }

  println(getPerson(User("Nik","Brown")))
  println(getPerson(Admin("Antony","Black")))
///////////////

  val list  = List(1,2,3,4)
  val head::tail = list

}






