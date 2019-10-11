package lectures.part5Monads

object Monads extends App{

  val x=5
  val monad:Option[Int] = Some(x)

  def squareFunction (x:Int):Option[Int]= Some(x*x)
  def incrementFunction (x:Int):Option[Int] = Some(x+1)

  //  Left-unit-law
  // unit(x) flatMap f == f(x)

  val leftRes = monad flatMap(squareFunction)
  val res2 = squareFunction(x)

  println(leftRes)
  println(leftRes == res2)

  // Right- unit-law
  // monad flatMap unit == monad

  val rightRes = monad flatMap(x=>Some(x))
  val res3 = monad

  println(rightRes)
  println(rightRes == res3)

  // Associativity-law
  // (monad flatMap f) flatMap g == monad flatMap( x=>f(x) flatMap g )

  val left = monad flatMap(squareFunction) flatMap(incrementFunction)
  val right = monad flatMap(x=> squareFunction(x) flatMap(incrementFunction))

  println(left)
  println(right)
  println(left==right)

  // map, flatmap, filter

  val myFirstOption: Option[Int] = Some(4)

  println(myFirstOption.isEmpty)
  println(myFirstOption.map(x=>x*2))
  println(myFirstOption.flatMap(x=> Some(x*2)))
  println(myFirstOption.filter(x=> x>10))
}
