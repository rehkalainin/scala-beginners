package exercises.ex2

object MyMonadEx extends App {

  trait MyMonad[+A]{
    def flatMap[B](f:A=>MyMonad[B]):MyMonad[B]
  }
  object MyMonad {
    def apply[A](value:A):MyMonad[A]= {
      try {
        Success(value)
      } catch {
        case e:Throwable=> Fail(e)
      }
    }
  }
  case class Success[+A] (value:A) extends MyMonad[A]{
    override def flatMap[B](f: A => MyMonad[B]): MyMonad[B] = {
      try {
        f(value)
      } catch {
        case e:Throwable => Fail(e)
      }
    }
  }
  case class Fail[Throwable](e:Throwable) extends MyMonad[Nothing]{
    override def flatMap[B](f: Nothing => MyMonad[B]): MyMonad[B] = this
  }
}
