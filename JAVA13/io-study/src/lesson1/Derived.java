package lesson1;

class Base{
    public Base(String s){
        System.out.println("B");
    }
    public Base(){

    }

}

public class Derived extends Base{
    public Derived(String s){

    }

    public static void main(String[] args) {
        String s="hhhhaaa";
        s.indexOf("hh");
    }
}
