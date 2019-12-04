package exercises.ex2

object MyMapEx extends App {

  trait MyMap[A,+B] extends PartialFunction[A,B]{
    def apply(key:A):B
    def get(key:A):Option[B]
  }

}
