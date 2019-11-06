package lectures.part4Collections

object Streem extends App{

  val s :String="aaaavvvccdddddee"

  val lettersList:Stream[String] = s.toStream.map(x=>x.toString)
  val group = lettersList.toList.groupBy(x=>x.charAt(0))

  println(lettersList)
  println(group)



}
