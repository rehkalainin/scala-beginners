package exercises.ex2

object MySetEx extends App {

  sealed trait MySet[A] extends (A=>Boolean){
    def apply (element:A):Boolean=conteine(element)
    def conteine (element:A):Boolean
    def + (element: A): MySet[A]
    def ++ (set: MySet[A]):MySet[A] // union another set

    def map[B](f: A=>B):MySet[B]
    def flatMap[B](f: A=> MySet[B]):MySet[B]
    def filter(p: A=> Boolean):MySet[A]
    def foreach(f: A=>Unit):Unit

    // ex2

    def - (element:A):MySet[A] // removing element
    def -- (anotherSet:MySet[A]):MySet[A] // difference
    def & (anotherSet:MySet[A]):MySet[A] // intersection

  }

     class EmptySet[A] extends MySet[A] {
    override def conteine(element: A): Boolean = false
    override def +(element: A): MySet[A] = nSet(element,this)
    override def ++(set: MySet[A]): MySet[A] = set
    override def map[B](f: A => B): MySet[B] = new EmptySet[B]
    override def flatMap[B](f: A => MySet[B]): MySet[B] = new EmptySet[B]
    override def filter(p: A => Boolean): MySet[A] = this
    override def foreach(f: A => Unit): Unit = ()
       override def -(element: A): MySet[A] = this
       override def --(anotherSet: MySet[A]): MySet[A] = this
       override def &(anotherSet: MySet[A]): MySet[A] = this

     }
  case class nSet[A] (h:A, t:MySet[A]) extends MySet[A] {
    override def conteine(element: A): Boolean = {
      h== element || t.conteine(element)
    }
    override def +(element: A): MySet[A] = {
      if (this.conteine(element)) this
      else nSet(element,this)
    }
    override def ++(set: MySet[A]): MySet[A] = nSet(h, t++set)
    override def map[B](f: A => B): MySet[B] = nSet(f(h), t.map(f))
    override def flatMap[B](f: A => MySet[B]): MySet[B] = f(h)++ t.flatMap(f)
    override def filter(p: A => Boolean): MySet[A] = {
      if(p(h)) nSet(h,t.filter(p))
      else t.filter(p)
    }
    override def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
    }
    override def -(element: A): MySet[A] = {
      if(h==element) t
      else t - element + h
    }
    override def --(anotherSet: MySet[A]): MySet[A] = filter(x=> !anotherSet.conteine(x))
    override def &(anotherSet: MySet[A]): MySet[A] = filter(anotherSet)
  }
object MySet{
  def apply[A](elements: A*): MySet[A]={
    def helper(remaining:Seq[A], result:MySet[A] ):MySet[A]={
      if(remaining.isEmpty)result
      else helper(remaining.tail, result+remaining.head)
    }
    helper(elements, new EmptySet)
  }
}
  val numberSet = MySet(1,2,3,1,2)
  numberSet foreach print

  println(numberSet+6)
  val set2= MySet(1,2,3,7,8,9)
  println(numberSet++set2)
  println(numberSet.map(x=>x*10))
  println(numberSet.flatMap(x=>MySet(x*10)))
  println(numberSet.filter(x=>x%2==0))

}
