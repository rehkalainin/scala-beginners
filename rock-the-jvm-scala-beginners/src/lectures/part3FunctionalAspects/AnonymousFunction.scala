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
}
