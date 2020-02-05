package exercises.ex1

object HPandDemage extends App {

  // Дано здоровье героя HP = 100
  // Герой начинает схватку с противником и получает урон. Урон представлен шквалом ударов и храниться в Seq(5, 15, 25, 30, 7, 40, 45)
  // При получение урона герой теряет жизни. т.е. 100 - 5 = 95; 95 - 15 = 80 ...
  // TODO: Получить HP героя после шквала ударов, если здоровье упало ниже 0 то выдать ошибку с сообщением о гибели героя.
  // val newHP = ???
  val HP = 100
  val seq = Seq(5, 15, 25, 30, 7)
  val newHP = seq.foldLeft(HP){(hp, hit)=>
    if (hp>0) hp-hit
    else throw new Exception (s"Herow is died!")
  }

  println(newHP)

  // Дано здоровье героя HP = 100
  // Герой начинает схватку с противником и получает урон. Иногда противник промахиваеться.
  // Урон и промахи храниться в Seq(Some(5), None, Some(15), Some(25), None, Some(30), Some(7), Some(40), Some(45))
  // При получение урона герой теряет жизни. т.е. 100 - 5 = 95; 95 - None = 95, 95 - 15 = 80 ...
  // TODO: Просчитать сколько ударов способен пережить герой

  val hits = Seq(Some(5), None, Some(15), Some(25), None, Some(30), Some(7), Some(40), Some(45))

  val hitCount = hits.foldLeft((100, 0)) { (newHp, hit) =>
    hit match {
      case Some(demage) if newHp._1 - demage >= 0 => (newHp._1, newHp._2 + 1)
      case None => (newHp._1, newHp._2)
      case _ => newHp
    }
  }

  println(hitCount._2)

}
