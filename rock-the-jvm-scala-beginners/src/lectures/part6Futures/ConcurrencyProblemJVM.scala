package lectures.part6Futures


import java.util.concurrent.{ExecutorService, Executors}


object ConcurrencyProblemJVM extends App{

  class BankAcount(var amount: Int){
    override def toString = s"BankAcount($amount)"
  }

  // no safe no synchronised
  def buy (account:BankAcount, thing:String, price:Int): Unit ={
    account.amount -= price
    println(s"I've bought: $thing")
    println(s"my amount is : $account")
  }

/*
  for (_<- 1 to 10){
    val account = new BankAcount(50000)
    val thread1 = new Thread(()=>buy(account,"Shoes", 3000))
    val thread2 = new Thread(()=>buy(account,"IPhone", 4000))

    thread1.start()
    thread2.start()
    Thread.sleep(10)
    if(account.amount != 43000) println("AHA: "+ account.amount)
  }

 */

// synchronysed
  def buySafe (account:BankAcount, thing:String, price:Int): Unit ={
    account.synchronized({ // only one thread can use at one time
      account.amount -= price
      println(s"I've bought: $thing")
      println(s"my amount is : $account")
    })
  }
  for (_<- 1 to 10){
    val account = new BankAcount(50000)
    val thread1 = new Thread(()=>buySafe(account,"Shoes", 3000))
    val thread2 = new Thread(()=>buySafe(account,"IPhone", 4000))

    thread1.start()
    thread2.start()
    Thread.sleep(10)
    if(account.amount != 43000) println("AHA: "+ account.amount)

  }
  // JVM Treads
  val myTrears = new Thread(()=>println("I am working is parallel"))
  myTrears.start()

  // executors and tread pool
  val pool :ExecutorService = Executors.newFixedThreadPool(10)



}

