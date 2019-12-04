package lectures.part3FunctionalAspects

object Carryng extends App{

  def div(id:String, css:String)(s: => String):String={
      id+" "+css+" "+s
  }
  val html = div("id0123","fff000") _
  val name = "Valera"
  html(name)

  println(html.toString())

  // Curried function
  val superAdder : Int=>Int=>Int =  x=> y=> x+y

  val add3 = superAdder(3) // : Int=>Int = y => 3+y
  println(add3(5))
  println(superAdder(3)(5))
  println(superAdder(3))
  //println(superAdder(3) _ ) // ошибка - должен следовать метод в ()

  // Curried Metod
  def curriedAdder (x:Int)(y:Int):Int= x+y

  val add4: Int=> Int = curriedAdder(4)
  // lifting function to metod = ETA-Expansion
  // Partial function applications
  val addETA4 = curriedAdder(4) _ // : Int=> Int

  //Exercise
  val simpleAddFunction = (x:Int, y:Int)=> x+y // function
  def simpleAddMetod (x:Int,y:Int)=x+y // metod
  def curriedAddMetod (x:Int)(y:Int)= x+y // curried metod
  //realize
  // add7: Int=> Int = y => 7+x

  val add7 = (x:Int)=>simpleAddFunction(7,x)
  val add7_1 = simpleAddFunction(7,_:Int)
  val add7_2 = simpleAddFunction.curried(7)

  val add7_3 = simpleAddMetod(7, _:Int)

  val add7_4 = curriedAddMetod(7) _ // PAF
  val add7_5 = curriedAddMetod(7)(_) // PAF alternative

  // underscror are powerful
  def concatenator(a:String, b:String, c:String)= a + b +c
  val insertName = concatenator("Hello, I am ", _:String, "How are you? " )
  println(insertName("Kostya "))



}
