
class HelloA{
    public HelloA(){
        System.out.println("I am HelloA");
    }
    static{
        System.out.println("class HelloA");
    }
}

public class HelloB extends HelloA{

    public HelloB(){
        System.out.println("I am HelloB");
    }
    static{
        System.out.println("class HelloB");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}
