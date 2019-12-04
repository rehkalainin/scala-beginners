package exercises.ex2

object MyTreeEx extends App {
  sealed trait Tree[+A]
  case class Leaf[A](v: A) extends Tree[A]
  case class Node[A](left: Tree[A], v: A, right: Tree[A]) extends Tree[A]


    def map[A, B](tree: Tree[A])( f: A => B): Tree[B] = tree match {
      case Leaf(v)=> Leaf(f(v))
      case Node(left, v, right)=> Node(map(left)(f), f(v), map(right)(f))
    }

  val sampleTree = Node(
    Node(Leaf(1), 2, Leaf(3)),
    4,
    Node(Leaf(5), 6, Node(Leaf(7), 8, Leaf(9))
    ))
  println {
    map(sampleTree)(x=>x+1)
  }

  def fold[A, B](tree: Tree[A])(zero: B)(f: (B, A) => B): B =  {
      def helper(tree:Tree[A])(res:B):B = tree match {
        case Leaf(v)=> f(res,v)
        case Node (left, v, right)=>
//          val acc1 = helper(left)(res)
//          val acc2 = f(acc1, v)
//
//          val acc = f(helper(left)(res),v)
//
//          helper(right)(acc2)
          helper(right)(
            f(
              helper(left)(res),
              v
            )
          )
      }
    helper (tree:Tree[A])(zero:B)

  }
  println {
    fold(sampleTree)(0)(_+_)
  }

}
