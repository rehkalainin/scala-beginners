package exercises.ex1;

public class Service {

    void foo1(final Counter c){
   // c = null; // не скомпилируется т.к final не даст изменить
    }

    void foo2(Counter c){
        c=null;
     //   System.out.println(c.value); // NullPointerExeptional нельзя обратиться к полю несуществующекго объекта
    }
    void foo3(Counter c){
        c.value=100;
        System.out.println(c.value);
    }
}
