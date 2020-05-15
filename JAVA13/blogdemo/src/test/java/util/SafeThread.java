package util;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeThread {
    //private static int SUM;

    private static int NUM=20;

    private static int COUNT=10000;
    private static AtomicInteger SUM = new AtomicInteger();

    public static void main(String[] args) {
        //同时启动20个线程，每个线程对同一个变量进行++操作，每次循环100次。
        //所有线程执行完，打印SUM，观察是否是200000
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    for (int j = 0; j <COUNT ; j++) {
//                        increment();
//                    }
                    synchronized (SafeThread.class){
                        SUM.incrementAndGet();//n++
                    }
//                    synchronized (this){//对Runnable对象进行加锁
//                        SUM++;
//                    }
                }
            }).start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        //1.不是预期结果200000
        //2.每次运行结果不一样
        System.out.println(SUM);
    }


    /**等同于
    *   synchronized(SafeThread.class){ ... }
    * */
    public static  synchronized void increment(){ //对当前类对象进行加锁
        SUM.incrementAndGet();
    }
//     public static synchronized  void increment(){
//        synchronized (SafeThread.class){
//            SUM++;
//        }
//     }


    /**等同于
     * synchronized(this){
     *     ...
     * }
     * */
    //new SafeThread().increment2();

    public synchronized void increment2(){  //对当前实例对象进行加锁
            SUM.incrementAndGet();
    }
//    public  void increment2(){  //对当前实例对象进行加锁
//        synchronized (this){
//            SUM++;
//        }
//    }
}
