package lesson5;

public class Sington {

    private Sington() {

    }

    //懒汉模式
//    private static Sington SINGTON = null;
//
//    public static Sington getInstance() {
//        if (SINGTON == null) {
//            SINGTON = new Sington();
//        }
//        return SINGTON;
//    }


    //饿汉模式
//    private static Sington SINGTON=new Sington();
//
//    public static Sington getInstance(){
//        return SINGTON;
//    }

    //双重检验锁
    /**假设不使用volatile修饰SINGTON变量：但在保证可见性的前提下，不保证重排序的情况下，不能实现线程安全*/

    //双重检验锁实现单例模式
    private static volatile Sington SINGTON=null;
    public static Sington getInstance(){
        //提高效率，使用volatile保证可见性
        if(SINGTON==null){
            synchronized (Sington.class){
                //保证实现单例，返回的是同一个变量
                if(SINGTON==null){
                    //new分解为三条指令
                    //1.分配内存空间
                    //2.初始化对象
                    //3.赋值给变量
                    SINGTON=new Sington();
                }
            }
        }
        return SINGTON;
    }



}
