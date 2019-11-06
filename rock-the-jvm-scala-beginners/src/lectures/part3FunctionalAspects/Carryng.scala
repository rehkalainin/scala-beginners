package lectures.part3FunctionalAspects

object Carryng extends App{

  def div(id:String, css:String)(s: => String):String={
      id+" "+css+" "+s
  }
  val html = div("id0123","fff000")_
  val name = "Valera"
  html(name)

  println(html.toString())
}
