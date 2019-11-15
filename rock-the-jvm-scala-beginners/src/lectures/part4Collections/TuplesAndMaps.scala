package lectures.part4Collections
import Array.ofDim
object TuplesAndMaps extends App{

// multidimentional Arrays

  var a =ofDim[Int](3,3)
  var k=1
  for(i<-0 to 2){
    for(j<-0 to 2){
      a(i)(j) = i+k
      k+=1
    }
    k-=1
  }

  // tuples
  val aTuples = (2, "Hello Scala")
  println(aTuples)
  val bTuples= aTuples.copy(2,"Goodbuy Java")
  val cTuples= aTuples.copy(_1 = 1)
  val dTuples = 'a'->2
  println(bTuples)
  println(cTuples)
  println(bTuples.swap)
  println(s"dTuples :  $dTuples")

  // map

  val aMap : Map[String, Int] = Map()
  val bMap = aMap + ("aaa"->1)
  println("bMap "+bMap)

  val charMap:Map[Char,List[Char]]= Map()
  val aCharMap = charMap+('a'->List('a'))
  println("aCharMap "+ aCharMap)
  val bCharMap = aCharMap ++ Map('b'->List('b'))
  println("bCharMap "+ bCharMap)
  val aabCharMap = if (bCharMap.contains('a')) bCharMap + ('a'->(bCharMap('a') :+ 'a'))
                    else bCharMap ++ aCharMap
  println("aabCharMap "+aabCharMap) /// aabCharMap Map(a -> List(a, a), b -> List(b))

  val phonebook: Map[String,Int] = Map(("Jim",555), "Marry" ->757).withDefaultValue(-1)


  //a -> b is suger (a,b)



  // map aps

  println(phonebook.contains("Jim"))
  println(phonebook.contains("Axel"))
  println("phonebook(Jim) "+phonebook("Jim"))

  // add pair

  val pair1 = "Kos"-> 127
  val pair2 = Map("Petr"->651, "Sasha"->652)
  val newPhonebook = phonebook + pair1
  val newPhonebook2 = newPhonebook ++ pair2

  println("newPhoneBook "+newPhonebook)
  println("newPhoneBook2 "+newPhonebook2)

  // map, filter, flatMap

 // println(phonebook.map{case(key,value)=>(key.)}
  println(phonebook.map{ case (key, value) => (key.toLowerCase, value)})
  println(newPhonebook2.map(pair=>pair._1.toLowerCase ->pair._2))
  println(newPhonebook2.map(x=>(x._1.toLowerCase, x._2)))
  println(newPhonebook2.map(x=>(x._1.toLowerCase)))
  println(newPhonebook2.map(x=>(x._2 + 1)))

// filter

  println(newPhonebook2.filterKeys(x=> x.startsWith("J")).mapValues(v=>"1uu1 " + v))
  println(newPhonebook2.filter(pair=> pair._1.startsWith("K")))

// groupBy List => Map
  // sortBy

  println(newPhonebook2.toList)

  val nameList = List("Andrey", "Anton", "Jim", "Andrey", "Bob","Bil","Jim","jim")
  val numberList = List(1,2,3,4,5,1,2,3,1,2,3,1,2,1)

  println(nameList.groupBy(name=>name.charAt(0))) // Map(J -> List(Jim, Jim), A -> List(Andrey, Anton, Andrey), j -> List(jim), B -> List(Bob, Bil))
  println(nameList.groupBy(identity)) // Map(Anton -> List(Anton), Jim -> List(Jim, Jim), Bob -> List(Bob), Bil -> List(Bil), jim -> List(jim), Andrey -> List(Andrey, Andrey)
  println(nameList.groupBy(identity).map(x=>(x._1, x._2.size))) // Map(Anton -> 1, Jim -> 2, Bob -> 1, Bil -> 1, jim -> 1, Andrey -> 2)

  println(numberList.sortBy(identity)) // List(1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 5)
  println(nameList.sortBy(identity)) // List(Andrey, Andrey, Anton, Bil, Bob, Jim, Jim, jim)




}
