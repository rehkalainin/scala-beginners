package lectures.part5Monads

import scala.util.Random

object ConnectionExercise extends App {

  val config : Map[String,String] = Map(
    "host" -> "176.45.36.1",
    "post" -> "80"
  )

  class Connection {
    def connect = "Connect"
  }
  object Connection{
    val random = new Random(System.nanoTime())
    def apply(host:String, port:String):Option[Connection]={
      if(random.nextBoolean()) Some(new Connection)
      else None
    }
  }
  // try to establish connection
  // 1
 /* val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h=>port.flatMap(p=>Connection.apply(h,p)))
  val connectionStatus = connection.map(c=>c.connect)
  println(connectionStatus)
*/
    // 2

  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p=>Connection(h,p))
      .map(c=>c.connect))
    .foreach(println)
}
