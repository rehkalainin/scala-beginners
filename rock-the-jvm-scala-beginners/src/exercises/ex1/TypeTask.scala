package exercises.ex1


object TypeTask extends App {

  class Container1[-T] { // на вход B<:T или T или ВСЕ, выход нельзя T
     val x: Any = ??? // compile error
    def set[B<:T](p: Int): Unit = ???

    def get:Int = ??? // compile error
  }
  class Container2[+T] { // на вход B>:T, нельзя T, выход ВСЕ
    val x: T = ???
    var y: Any = ??? // compile error
    def set[B>:T](p: B):Unit = ??? // compile error
    def get: T = ???
  }

}
