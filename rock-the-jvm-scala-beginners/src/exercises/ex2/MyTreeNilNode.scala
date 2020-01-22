package exercises.ex2

object MyTreeNilNode extends App {

  sealed trait Tree

  case class Node(v: Int, left: Tree, right: Tree) extends Tree

  case object Nil extends Tree

  object Tree {

    def fold[B](tree: Tree, zero: B)(f: (Int, B, B) => B): B = {
      tree match {
        case Nil => zero

        case Node(velue, left, right) => f(velue, fold(left, zero)(f), fold(right, zero)(f))
      }
    }

  }

  val in = Node(1, Node(3, Nil, Node(1, Nil, Nil)), Node(2, Nil, Nil))
  println(s"Res = ${Tree.fold(in, 0)(_ + _ + _)}")
}
