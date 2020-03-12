package lesson3;

public class InterruptThread {

    //中断一个线程，但是线程没有处理这个中断
    public static void test1() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });

        t.start();
        t.interrupt();

    }

    public static void test2() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //线程运行时，需要自己判断中断标志位，处理中断操作
//                while(!Thread.currentThread().isInterrupted()){
                while (!Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });

        t.start();//t线程的中断标志位false
        t.interrupt();
    }

    public static void test3() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //线程在阻塞状态时，通过捕获及处理异常，来进行线程的中断逻辑
                try {
                    System.out.println(Thread.currentThread().isInterrupted());//true
                    //线程处于调用wait/join/sleep方法造成阻塞时，
                    // 如果将当前线程中断掉，会直接抛出异常，之后线程的中断标志位会重置
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().isInterrupted());//false
                }

            }

        });

        t.start();//t线程的中断标志位false
        t.interrupt();
    }

    public static void test4(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //System.out.println(Thread.interrupted());//返回中断标志位，并重置标志位
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t.start();
        t.interrupt();

    }
    private static volatile boolean IS_INTERRUPTED;
    //使用自定义中断标志位
    public static void test5(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                //自定义标志位能满足线程运行时的中断操作
//                while(!IS_INTERRUPTED){
//                    System.out.println(Thread.currentThread().getName());
//                }
                //自定义标志位满足不了线程阻塞态的中断操作
                try {
                    Thread.sleep(200000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        IS_INTERRUPTED=true;

    }
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
    }
}
