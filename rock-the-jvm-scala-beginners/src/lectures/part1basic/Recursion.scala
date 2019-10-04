package lectures.part1basic

object Recursion extends App {
// factorial without accumulator

  def factorialSlow(number: Int): Int = {
    if (number <= 1) 1
    else number * factorial(number - 1)
  }

  // factorial with accumulator

  def factorial(x:Int):Int ={

    def fact(x:Int, acc:Int):Int={
      if(x<=1) acc
      else fact(x-1, x*acc)
    }
    fact(x,1)
  }

  println(factorial(10))

  def anotherRecursion(n: BigInt): BigInt = {
    def helper(x: BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else helper(x - 1, x * accumulator)

    helper(n, 1)
  }

  def concat (world: String, n:Int, accumulator: String): String={
    if(n<1)accumulator
    else concat(world, n-1, world+accumulator)
  }

  def fibo (n:Int):Int={
    def fiboTail(i:Int, last:Int, nextLast:Int):Int=
      if (i >= n) last
      else fiboTail(i + 1, last + nextLast, last)

      if(n<=2)1
      else fiboTail(2,1,1)
    }


  println(anotherRecursion(100))
  println(concat("hello",3,""))
  println(fibo(8))
}
