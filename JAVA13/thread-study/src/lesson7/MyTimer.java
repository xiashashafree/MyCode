package lesson7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**定时器
 * 1.在约定好的时间点上，执行某个任务
 * 2.经过间隔时间，一直执行任务
 * */
public class MyTimer {
    BlockingQueue<MyTimerTask> queue=new PriorityBlockingQueue<>();

    public MyTimer(int size){

        for (int i = 0; i < size; i++) {

            new Thread(new MyWorker(queue)).start();

        }

    }


private static class MyWorker implements Runnable{
        private BlockingQueue<MyTimerTask> queue;
    public MyWorker(BlockingQueue<MyTimerTask> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        try {
            while(true){
                MyTimerTask task=queue.take();
                synchronized (queue){
                    long current=System.currentTimeMillis();
                    if(task.next>current){
                        queue.put(task);
                    }else{
                        task.task.run();
                        if(task.period>0){
                            task.next=task.next+task.period;
                            queue.put(task);
                        }
                    }
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}




    /**
     * 定时任务
     * @param task 需要执行的任务
     * @param delay 延迟时间
     * @param period 间隔时间
     */
    public void schedule(Runnable task,long delay,long period){

        try {
            queue.put(new MyTimerTask(task,System.currentTimeMillis()+delay,period));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 具体的定时任务
     */
    private static class MyTimerTask implements Comparable<MyTimerTask>{

        private Runnable task;
        private long next;

        private long period;

        public MyTimerTask(Runnable task,long next,long period){
            this.task=task;
            this.next=next;
            this.period=period;
        }
        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(this.next,o.next);
        }
    }

    //    public void schedule(Runnable task,long delay,long period){
//        try {
//            Thread.sleep(delay);
//            new Thread(task).start();
//            while(period > 0){
//                Thread.sleep(period);
//                new Thread(task).start();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        //Date
//        Date date1=new Date();//无参构造方法：返回系统当前时间
//        Date date2=new Date(999999999);//从格林威治时间1970-01-10到当前时间的，经过的时间毫秒
//        //DateFormat
//        DateFormat df=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        System.out.println(df.format(date1));
//        System.out.println(df.format(date2));

        //system时间
        //从格林威治时间1970-01-10到当前时间的，经过的时间毫秒
//        long current=System.currentTimeMillis();
//        System.out.println(current);
//        TimerTask task=new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("coding");
//            }
//        };
//        new Timer().schedule(task,3,1);
//        new MyTimer().schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("coding -_-|||");
//            }
//        },3000,1000);
//        ExecutorService pool=Executors.newSingleThreadExecutor();//线程池中只有一个正式与员工
//        ExecutorService pool=Executors.newFixedThreadPool(4);//正式员工有4个，无临时工
        ScheduledExecutorService pool=Executors.newScheduledThreadPool(4);//正式员工4个
//        ExecutorService pool=Executors.newCachedThreadPool();//正式员工为0，临时工数量不加限制
//        pool.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println();
//            }
//        },3,TimeUnit.SECONDS);
//        pool.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("coding -_-|||");
//            }
//        },3,0,TimeUnit.SECONDS);

        new MyTimer(4).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床了");
            }
        }, 3000, 1000);

    }
}
