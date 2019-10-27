package lectures.part3FunctionalAspects

object AnonymousFunction extends App{

  val f1 = (str1:String, str2:String)=>str1+str2

  val f2 = (_:String)+ (_:String)

  println(f1("Hello","Scala"))
  println(f2("Hello","Scala2!!"))

  def myFunction (fun:(String,String)=>String)=
    fun("Dog","Cat")

  def moneyTransfer(amount: Double, providerFee:Double=>Double):Double = {
    amount +10+providerFee(amount)
  }

  def providerA(money:Double):Double = money*0.05

  println(moneyTransfer(100,providerA))

/// Anonymous function useing for lyambda expression
  // on based on functional traits or abstract classa with 1 abstract metod

  trait Acting{
    def act(x:Int):Int
  }
  val dog:Acting = new Acting {
    override def act(x: Int): Int = x*10
  }

  val cat:Acting = (x)=> x+1

  println(dog.act(5))
  println(cat.act(1))
}


