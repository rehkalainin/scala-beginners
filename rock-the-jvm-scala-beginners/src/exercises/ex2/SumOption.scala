package exercises.ex2

import java.util.OptionalInt

object SumOption extends App {

  val x:Option[Int]=Some(2)
  val y:Option[Int]=Some(3)
  val z:Option[Int]=Some(4)

  val sum:Option[Int] = for {
      sx <- x
      sy <- y
      sz <- z
  }yield {
    sx+sy+sz
  }
println(sum)

  val sum2:Option[Int] = x.flatMap(sx=>y.flatMap(sy=>z.map(sz=>sx+sy+sz))) // через map
  val sum3:Option[Int] = x.flatMap(sx=>y.flatMap(sy=>z.flatMap(sz=>Some(sx+sy+sz))))// через flatMap
  println(sum2)

}
