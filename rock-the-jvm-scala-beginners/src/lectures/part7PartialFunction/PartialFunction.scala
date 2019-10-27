package lectures.part7PartialFunction

import java.time.LocalDateTime

object PartialFunction extends App {

  // chat bot

  val chatbot : PartialFunction[String, String]={
    case "hello" => s"Hello master! What can I help?"
    case "time" => s"time: "+ LocalDateTime.now()
    case s:String => s
  }

  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)

  //scala.io.Source.stdin.getLines().foreach(line=> println(s"chatbot says: "+ chatbot(line)) )

}
