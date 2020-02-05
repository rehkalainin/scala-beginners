package lectures.part3FunctionalAspects

object MatcingCaseClasses {
  case class Pet(name: String, says: String)

  val pet = Pet("Re1", "nya21")
  val kind = pet match {
    case Pet("Rex", _) => "dog"
    case Pet(_, says) if says == "meow" | says == "nya" => "cat"
    case Pet(_, says) if says.contains(0) => "robot"
    case Pet(_, says) if says.contains('1') | says.contains('0') => "robot"
    case _ => "unknown"
  }


  println(kind)


}
