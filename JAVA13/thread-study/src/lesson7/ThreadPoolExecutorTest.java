package lesson7;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
//       ExecutorService pool=Executors.newFixedThreadPool(4);//创建线程池，里面有4个线程

        ExecutorService pool=new ThreadPoolExecutor(//线程池----快递公司
                3, //核心线程数(正式员工)：创建好线程池，正式员工就开始取快递

                //临时工雇佣：正式员工忙不过来时，创建临时线程
                //临时工解雇：空闲时间大于设置的时间范围时，解雇它

                5,//最大线程数（最多数量的员工：正式工+临时工

                10,//时间数量
                TimeUnit.SECONDS,//时间单位（时间数量+时间单位表示一定时间范围）

                //阻塞队列：存放包裹的仓库（存放任务额的数据结构）
                new ArrayBlockingQueue<>(1000),

                //线程池使用创建Thread的工厂类，没有提供就使用线程池内部的默认创建线程方式
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        return null;
//                    }
//                },

                //拒绝策略：
                //CallerRunsPolicy:谁（execute（代码行所在的线程）让我去送快递时，不去送，让它自己去送
                //AbortPolicy:线程池直接抛出异常RejectedExecuteException
                //DiscardPolicy:从阻塞队列队尾丢弃最新任务
                //DiscardOldestPolicyPolicy:从阻塞队列队首丢弃最旧任务
                new ThreadPoolExecutor.CallerRunsPolicy());
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到西安，A");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到广东，B");
            }
        });

        System.out.println("我在敲代码");
    }

}
