package exercises.ex2

object MySeqEx extends App {

  trait MySeq[+A] extends PartialFunction[Int, A]
}