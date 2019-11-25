package exercises

import exercises.ex1.App

abstract class MyList[+A] {

  def head:A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B>:A] (element:B): MyList[B]
  def printElement: String
  override def toString = "[" + printElement+ "]"
  def map[B](transformer: MyTransformer[A,B]):MyList[B]
  def flatMap[B](transformer: MyTransformer[A,MyList[B]]):MyList[B]
  def filter(predicate: MyPredicate[A]):MyList[A]
  def ++[B>:A](list:MyList[B]):MyList[B]
}

case object Empty extends MyList[Nothing]{

  def head : Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B>:Nothing](element:B): MyList[B] = new Cons (element, Empty)
  def printElement: String = " "

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h:A, t:MyList[A]) extends MyList[A] {

  def head :A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B>:A] (element:B): MyList[B] = new Cons (element,this)
  def printElement: String = {
    if(t.isEmpty) "" + h
    else h+ " "+ t.printElement
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h),t.map(transformer))

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h)++ t.flatMap(transformer)

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h)) new Cons(h,t.filter(predicate))
    else t.filter(predicate)
  }
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons (h, t++list)
}

trait MyPredicate[-A] {
  def test(element: A): Boolean
}

trait MyTransformer[-A,B]{
  def transform (element: A):B
}

object ListTest extends App{
  val list = new Cons (1, new Cons(2,new Cons(3,Empty)))
  val listOfInt = new Cons(1,new Cons(2,new Cons(3,Empty)))
  val listOfString = new Cons("Hello", new Cons("Scala", Empty))

 println(listOfInt.printElement)
  println(listOfInt.toString)
  println(listOfString.printElement)
// println(list.flatMap(x=>x*10))




}
