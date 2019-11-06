package exercises.ex1;

public class App {
    public static void main(String[] args) {

        Counter c= new Counter();
        Service s = new Service();

        s.foo2(c);
        s.foo3(c);
    }
}
