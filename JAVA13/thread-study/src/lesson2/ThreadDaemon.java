package lesson2;

public class ThreadDaemon {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });

        //设置为守护线程
        t.setDaemon(true);
        t.start();
        System.out.println(Thread.currentThread().getName());

        //当进程内没有非守护线程时，进程退出
    }
}
