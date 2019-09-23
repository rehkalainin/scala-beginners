package lectures.part2oop

object MethodNotation extends App{

  val mary = new Person("Mary", favoriteMovie="Inception")
  val tom = new Person("Tom", favoriteMovie="XXX")

  println(mary.likes("Spiderman"))
  println(mary likes "Inception")
  println(mary())
  println(tom.apply())

  println(mary + tom)

  println(tom.isAlive)
  println((mary + "Rock star")())
  println(mary.apply(2))

  println((+mary).age)
  println(mary.addAge(31).age)
  println(mary.learnScala)
  println(mary learnJava)


}
  class Person (val name:String,  favoriteMovie: String, val age:Int=0){

    def likes(movie:String) = movie==favoriteMovie
    def + (person:Person): String = s"$name is handing out with $person.name"
    def + (nickName:String): Person = new Person (s"$name ($nickName)",favoriteMovie)
    def apply(): String = s"Hi, my name is $name and my favoriteMovie is $favoriteMovie"
    def apply(n:Int):String = s"$name watched $favoriteMovie of $n times"
    def unary_+ : Person = new Person (name, favoriteMovie, age+1)
    def addAge (n: Int):Person = new Person(name, favoriteMovie, n)
    def isAlive = true

    def learns(thing:String): String =s"$name lears $thing "
    def learnScala=  learns("Scala!!")
    def learnJava = this learns "Java!!"

  }

