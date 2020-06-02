package gc;

public class ObjectLifecycle {

    public static void test1(){
        /**
         * 0.类加载：产生类变量和相关对象
         * 1.创建局部变量p（存在方法栈帧）
         * 2.new Person()（存在堆）
         * 3.产生引用：p指向person对象
         */
        Person p = new Person();
    }//销毁main线程该次调用的方法栈帧--->p没有了--->person对象没有引用指向（gc roots不可达）

    public static void main(String[] args) {
        test1();//创建main线程对test1()该次调用的方法栈帧
        //do something
        //Person类相关的变量始终还是指向对象

        //要明确把Person类中Person对象回收，要将该对象引用清除（Person.P）
//        Person.P = 其他的对象/null;
    }
}

class Person{

    /**
     * 静态变量和静态代码块--->合并为类构造方法（字节码<clinit>）--->执行一次
     */
    /**
     * 1.OK类变量（方法区/元空间）
     * 2.常量池OK字符串对象
     * 3.OK变量引用产生：指向OK字符串对象
     */
    public static String OK = "OK";
    /**
     * 1.创建类变量（方法区/元空间）
     * 2.new Person()（存在堆）
     * 3.产生引用：p指向person对象
     */
    public static Person P = new Person();


    private Person p2 = new Person();
}
