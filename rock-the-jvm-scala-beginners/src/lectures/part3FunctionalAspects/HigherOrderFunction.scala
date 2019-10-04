package lectures.part3FunctionalAspects

object HigherOrderFunction extends App{

  val plusOne = (x:Int)=>x+1

  // nTimes(f,3,x) = f(f(f(x)))
  // nTimes(f,n,x) = nTimes(f,n-1,f(x))

  def nTimes (f:Int=>Int, n:Int, x:Int):Int={
    if(n<=0) x
    else nTimes(f,n-1,f(x))
  }

  println(nTimes(plusOne,10,1))

  //nTimesBetter
  def nTimesBetter (f:Int=>Int, n:Int):(Int=>Int)={
    if (n<=0) (x:Int)=>x
    else (x:Int)=> nTimesBetter(f,n-1)(f(x))
  }
  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(1))


}
