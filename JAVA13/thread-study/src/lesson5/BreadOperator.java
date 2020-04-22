package lesson5;

public class BreadOperator {

    //库存面包数量：上限：100  下限：0
    public   volatile static int SUM;

    public static void main(String[] args) {

        //启动5个生产者线程，生产面包
        for (int i = 0; i < 10; i++) {
            new Thread(new Procuder(),"面包师傅"+i).start();
        }

        //启动消费者线程，消费面包
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(),"消费者"+i).start();
        }
    }

    //默认生产者：面包师傅生产面包，一次生产3个
    private static class Procuder implements Runnable{

       @Override
       public void run() {
           try {
               for (int i = 0; i < 20; i++) {
                   synchronized (BreadOperator.class){

                       //生产完以后，库存大于100是不行的，所以库存>97时，不能生产
                       while(SUM+3>100){

                           //释放对象锁，需要让其他线程进入同步代码块，当前线程需进入阻塞状态
                           BreadOperator.class.wait();

                       }
                       Thread.sleep(10);
                       SUM=+3;//生产面包
                       BreadOperator.class.notify();
                       System.out.println(Thread.currentThread().getName()+"生产了，库存为："+SUM);
                       Thread.sleep(100);


                   }
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
   }


    //默认消费者：消费者购买面包，一次消费1个
    private static class Consumer implements Runnable{

        @Override
        public void run() {

            try {
                while(true){

                    synchronized (BreadOperator.class){
                        //库存为0，阻塞当前线程(不能消费)
                        while(SUM==0){
                            BreadOperator.class.wait();

                        }
                        Thread.sleep(10);
                        SUM--;
                        //notify()和notifyAll()唤醒因调用wait()方法阻塞的线程
                        //notify随机唤醒调用wait阻塞的线程，notify唤醒全部
                        //在synchronized代码块结束后，也就是释放对象锁之后，才会唤醒
                        //等于说synchronized结束后，wait和synchronized阻塞的线程都会被唤醒
                        BreadOperator.class.notifyAll();
                        System.out.println(Thread.currentThread().getName()+"消费了，库存为："+SUM);
                        Thread.sleep(100);

                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
