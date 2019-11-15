package lectures.part2oop

object Generics extends App {

  class MyList[A]  // параметризированный класс

  // Use type A
  val list1 = new MyList[Int]
  val list2 = new MyList[String]

  // generic metods
  object MyList{
    def empty[Int]:MyList[Int]= ??? // параметризированный метод
  }
  val emptyListOfInt = MyList.empty

    // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

      // 1. Yes -variance List[Cat] extends List[Animal] - Covariance
  class CovariantList[+A]
  val animal:Animal = new Cat // полиморфизм
  val animalList1: CovariantList[Animal] = new CovariantList[Cat] // для Animal и детей Animal
                                                                  // на выходе будут тип родителя

  // 2. No variance - Invariance
  class InvariantList[A]

  val animalList2:InvariantList[Animal] = new InvariantList[Animal] // только определенные типы

  // 3. Yes -varianse - Contrvariance
  class ContrList[-A]
  val animalList3:ContrList[Cat]= new ContrList[Animal] //  для типов родителей, выше Cat
                                                        // на выходе будет тип ребенка
}
