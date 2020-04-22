package lesson1;

class Test{
    static int number=3;
    public static void hello(){
        System.out.println("hello");
    }
}
public class MyApplication {
    public static void main(String[] args) {
        Test test=null;
        test.hello();
        System.out.println(test.number);
    }
}
