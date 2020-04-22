package lesson3;

public class UnsafeThread {

    private static int SUM;


    private static int NUM=20;

    private static int COUNT=10000;

    public static void main(String[] args) {
        //同时启动20个线程，每个线程对同一个变量进行++操作，每次循环100次。
        //所有线程执行完，打印SUM，观察是否是200000
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <COUNT ; j++) {
                        SUM++;//++操作不具有原子性
                              //1.从主内存复制到线程的工作内存
                              //2.在工作内存中修改变量
                              //3.将sum变量从线程的工作内存中写回到主内存
                    }
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

}
