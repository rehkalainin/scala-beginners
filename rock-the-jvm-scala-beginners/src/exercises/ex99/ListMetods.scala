package exercises.ex99

object ListMetods extends App{

//  P01 (*) Find the last element of a list.
  def last[A] (list:List[A]): A= list match {
    case head::Nil=> head
    case _::tail => last(tail)
    case Nil => throw new NoSuchElementException
  }

//  P02 (*) Find the last but one element of a list.
  def preLast[A](list:List[A]):A= list match {
    case x::_::Nil=> x
    case head::tail=> preLast(tail)
    case Nil | _::Nil => throw new NoSuchElementException
  }

 // P03 (*) Find the Kth element of a list.
  def findElementByIndex[A] (index:Int, list: List[A]): A = (index, list) match {
    case (0, h::_) => h
    case (k, _::t) if k>0 => findElementByIndex(k-1, t)
    case _ => throw new NoSuchElementException
  }

  def findK [A] (k:Int, list:List[A]):A = k match {
    case 0 => list.head
    case k if k>0 => findK(k-1, list.tail)
    case _ => throw new NoSuchElementException
  }

 // 04 - Find the number of elements of a list
  def lenght[A] (list:List[A]):Int= {
    def counter (n:Int, l:List[A]):Int=l match {
      case Nil => n
      case _::t => counter(n+1, t)
    }
    counter(0,list)
  }

  def lenghtByFold[A] (list:List[A]):Int={
    list.foldLeft(0)((c,_)=>c+1)
  }

  // 05 - Reverse a list
  def revers[A] (list:List[A]):List[A]= list match {
    case Nil => Nil
    case h::t=> revers(t):+h
  }

  def reversTail[A](list:List[A]):List[A] = {
    def helper[A](res:List[A], remaining:List[A]):List[A]=remaining match {
      case Nil => res
      case remaining => helper(List(remaining.head):::res,remaining.tail)

    }
    helper(Nil, list)
  }

  def reversByFold[A] (list:List[A])= {
    list.foldLeft(List[A]())((res, el)=> el::res)
  }

  // 06 - Find out whether a list is a palindrome
  def isPolindrom[A] (list:List[A]):Boolean=list match {
    case Nil => true
    case List(x) => true
    case list if (list.head == list.last)=> isPolindrom(list.tail.init)
    case _=> false

  }

  //07 - Flatten a nested list structure
  def flatten[A](list:List[A]):List[A]=list match {
    case Nil => Nil
    case (h:A)::t=> h::flatten(t)
    case (h:List[A])::t=> flatten(h):::flatten(t)
  }

  def flattenTail(list:List[Any]):List[Any]= {
    def helper(res:List[Any], remaining:List[Any]):List[Any]= remaining match {
      case Nil=> res
      case h::t=> helper(res:::List(h), t)
      case (h:List[_])::t=> helper(res:::h, t)

    }
    helper(Nil, list)
  }

  println(reversTail(List(1,2,3,4)))
}
