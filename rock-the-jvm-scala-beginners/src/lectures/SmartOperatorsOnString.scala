package lectures

object SmartOperatorsOnString extends App {

  val str:String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.startsWith("hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)
  println(str.reverse)
  println(str.take(10))

  // Scala specific String Interpolators

  val speed = 111.2d
  val name = "Danial"

  println(f"$name can eat $speed%f burgers per minet")
  println(f"$name can eat $speed%1.2f burgers per minute")
  println(s"$name can eat $speed \n burgers per minute")

}
