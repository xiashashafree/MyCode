
class Parent{
    private String name="hhhh";
    int age=0;
}
public class Child extends Parent{
    public int grade;

    public static void main(String[] args) {
        Parent p=new Child();
       // p.name;编译不通过
    }

}
