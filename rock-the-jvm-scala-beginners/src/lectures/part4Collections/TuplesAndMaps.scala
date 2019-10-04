package lectures.part4Collections

object TuplesAndMaps extends App{

  // tuples
  val aTuples = (2, "Hello Scala")
  println(aTuples)
  val bTuples= aTuples.copy(2,"Goodbuy Java")
  val cTuples= aTuples.copy(_1 = 1)
  println(bTuples)
  println(cTuples)
  println(bTuples.swap)

  // map

  val aMap : Map[String, Int] = Map()
  val phonebook: Map[String,Int] = Map(("Jim",555), "Marry" ->757).withDefaultValue(-1)

  //a -> b is suger (a,b)

  println(phonebook)

  // map aps

  println(phonebook.contains("Jim"))
  println(phonebook.contains("Axel"))
  println(phonebook("Jim"))

  // add pair

  val pair1 = "Kos"-> 127
  val pair2 = Map("Petr"->651, "Sasha"->652)
  val newPhonebook = phonebook + pair1
  val newPhonebook2 = newPhonebook ++ pair2
  println(newPhonebook)
  println(newPhonebook2)

  // map, filter, flashMap

 // println(phonebook.map{case(key,value)=>(key.)}
  println(phonebook.map{ case (key, value) => (key.toLowerCase, value)})
  println(newPhonebook2.map(pair=>pair._1.toLowerCase ->pair._2))
  println(newPhonebook2.map(x=>(x._1.toLowerCase, x._2)))
  println(newPhonebook2.map(x=>(x._1.toLowerCase)))
  println(newPhonebook2.map(x=>(x._2 + 1)))

// filter

  println(newPhonebook2.filterKeys(x=> x.startsWith("J")).mapValues(v=>"1uu1 " + v))
  println(newPhonebook2.filter(pair=> pair._1.startsWith("K")))

// conversion toList or toMap

  println(newPhonebook2.toList)

  val nameList = List("Andrey", "Anton", "Jim", "Bob","Bil")
  println(nameList.groupBy(name=>name.charAt(0)))

  // example overlap and simple social network

val nameMap = Map("Jim"->123, "JIM"-> 456, "JIM" -> 789, "Bil"-> 988)
  println(nameMap)
  println(nameMap("Bil"))
println(nameMap.map(pair=>pair._1.toLowerCase -> pair._2))

  def add (network: Map[String, Set[String]], person:String):Map[String,Set[String]]={
    network + (person->Set())
  }
}
