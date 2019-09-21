package lectures.part1basic

object DefaultAndNamed extends App{

  // default parametr

  def factorial(n:Int, acc:Int=1):Int={
    if(n<=1)acc
    else factorial(n-1, n*acc)
  }

  println(factorial(10))

  // named parametr

  def greeting(name:String="Valera", age:Int=23):String={
    s"Hi my name is $name and I am $age years old"
  }
  println(greeting())
  println (greeting(age=31))
  println(greeting(age=50, name="Vasya"))


}
