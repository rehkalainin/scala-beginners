package exercises.ex2

object Tests extends App{

  val v1= 4

  def square(x:Int):Int={x*x}

  def sum(x:Int, y:Int):Int={x+y}

  def multiply(x:Int, y:Int):Int={
    x*y
  }

  def global(z:Int, x:Int, y:Int, f: (Int,Int)=>Int)={
    z*f(x,y)
  }
  val res = global(2,2,2,sum)

  assert(v1==4,"Failed test v1")
  assert(sum(2,2)==4,"Failed test : sum")
  assert(global(2,3,4,sum) == 14, "Failed test: global-sum")
  assert(global(2,3,4,multiply)==24,"Failed test global-multiply")
  assert(res==8,"Failed test res")

//  val s:String = "aaabbcccdeeefgha"
//  List(
//    'a' -> 4,
//    'b' -> 2,
//    'c' -> 3,
//  ...
//  )

  val s:String = "aaabbcccda"

  def calc(s:String)= {
    s.toList.groupBy(identity).mapValues(_.size).toList.sortBy(_._1)
  }

  assert(calc(s)==List(('a',4),('b',2),('c',3),('d',1)),"Failed test calc")

}
