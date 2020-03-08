package lesson2;

public class ThreadYield {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });


        t.start();
        while(Thread.activeCount()>1){
            //当前运行线程从运行态变为就绪态
            Thread.yield();
            
        }

        System.out.println(Thread.currentThread().getName());
    }
}
