package exercises.ex2

object MyListEx extends App {

  abstract class MyList[+A]{
    def head:A
    def tail:MyList[A]
    def add [B>:A](element: B):MyList[B]
    def map[B](f: A=>B):MyList[B]
    def flatMap[B](f: MyFunction[A,MyList[B]]):MyList[B]
    def ++ [B>:A](list:MyList[B]):MyList[B]
    def filter (p: A=>Boolean):MyList[A]
  }
  object MyList{
    def apply[A](elements:A*):MyList[A]={
      def helper(remaining:Seq[A], res:MyList[A]):MyList[A]={
        if(remaining.isEmpty)res
        else helper(remaining.tail, res.add(remaining.head))
      }
      helper(elements,EmptyList)
    }
  }
  case object EmptyList extends MyList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException

    override def tail: MyList[Nothing] = throw new NoSuchElementException

    override def add[B >: Nothing](element: B): MyList[B] = new nList(element,EmptyList)

    override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

    override def map[B](f: Nothing => B): MyList[B] = EmptyList

    override def flatMap[B](f: MyFunction[Nothing,MyList[B]]): MyList[B] = EmptyList

    override def filter(p: Nothing => Boolean): MyList[Nothing] = EmptyList
  }
  case class nList[A](h:A, t:MyList[A]) extends MyList[A] {
    override def head: A = h

    override def tail: MyList[A] = t

    override def add[B >: A](element: B): MyList[B] = new nList(element,this)

    override def ++[B >: A](list: MyList[B]): MyList[B] =  nList(h, t++list )

    override def map[B](f: A => B): MyList[B] = new nList(f(h),t.map(f))

    override def flatMap[B](f: MyFunction[A,MyList[B]]): MyList[B] = f.transform(h)++t.flatMap(f)

    override def filter(p: A => Boolean): MyList[A] = {
      if (p(h)) new nList(h,t.filter(p))
      else t.filter(p)
    }

  }

//  trait MyFunction[-A, B]{
//    def transform (element:A):B
//  }
//
//  trait MyPredicat[-A]{
//    def check(element:A):Boolean
//  }
trait MyFunction[-T1, T2] {
  def transform(el:T1):T2
}

 // testing
  println(new nList(1,new nList(2,new nList(3,new nList(4,EmptyList)))).map(x=>x*10))

  println(new nList("Hello",EmptyList).add(2).add(3).add("Scala"))

  println(new nList("Hello",new nList("Scala",EmptyList)))

  val list1 = new nList(1,new nList(2,nList(3,EmptyList)))
  val list2 = new nList(4,new nList(5,nList(6,EmptyList)))
  val totalList = list1++list2
  println("total list "+ totalList)

  println("list sum "+ (List(1,2,3) ++ List(4,5)) )
  println("Set sum "+ (Set(1,2,3) ++ Set(4,5,6,7)) )





}
