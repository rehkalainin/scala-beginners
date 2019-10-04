package lectures.part2oop

object OOBasic extends  App {

  case class Point (val x: Int =0, val y: Int =0)
  val point1 = new Point
  val point2 = new Point (1)
  val point3 = new Point(y=2)
  val point4 = new Point(1,2)
  println(s"point1 = $point1; point2= $point2; /n point3 = $point3; point4 = $point4")


  val author = new Writer("Charls", "Dikkens", 1812)
  val book = new Novel ("Miracle", 1862, author )

  println(author.fullname)

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10)

  override def toString = s"OOBasic($point1, $point2, $point3, $point4)"
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
