package lectures

object Function extends App{

  def greeting (name:String, age:Int):String =
    s"Hello my name is $name and I am $age years old"


  def factorial (number:Int):Int ={
    if(number<=1) 1
    else number*factorial(number-1)
  }

  def fibo (n: Int): Int={
    if (n<=2) 1
    else fibo(n-1)+fibo(n-2)
  }




  println(greeting("Kostya", 31))
  println(factorial(5))
  println(fibo(8))

}
