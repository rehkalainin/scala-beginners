package exercises

object SocialNetwork extends App{

  def add (network: Map[String, Set[String]], person: String): Map[String, Set[String]]={
    network + (person -> Set())
  }

  def friends (network: Map[String, Set[String]], personA: String, personB: String):Map[String, Set[String]]= {
    val friendsA = network(personA)
    val friendsB = network(personB)
    network + (personA -> (friendsA + personB)) + (personB -> (friendsB + personA))
  }

  def unfriend (network:Map[String,Set[String]], personA:String, personB:String):Map[String,Set[String]]= {
    val friendsA = network(personA)
    val friendsB = network(personB)

    network + (personA -> (friendsA-personB)) + (personB -> (friendsB-personA))
  }

}
