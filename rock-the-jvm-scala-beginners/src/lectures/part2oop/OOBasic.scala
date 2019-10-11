package lectures.part2oop

object OOBasic extends  App {

  val author = new Writer("Charls", "Dikkens", 1812)
  val book = new Novel ("Miracle", 1862, author )

  println(author.fullname)

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10)
}


  class Writer (firstName: String, surname:String, val year:Int){

    def fullname= firstName+ " " + surname

  }

class Novel(name:String, year:Int, author: Writer){

 def authorAge = year - author.year
  def isWrittenBy(author:Writer) = author==this.author
  def copy (newAge:Int) :Novel = new Novel(name, newAge, author)

}

class Counter (val number:Int=0){
  def inc = {
    println("incrementing")
    new Counter(number + 1)
  }

  def dec = {
    println("decrementing")
    new Counter(number - 1)
  }

  def inc (n: Int):Counter= {
    if (n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n:Int):Counter={
    if(n<=0)this
    else dec.dec(n-1)
  }
  def print = println(number)
}
