package free;

import java.util.concurrent.*;


/**
 * Callable创建线程
 * Future/FutureTask
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("here");
                return 12;
            }
        };
        FutureTask<Integer> task = new FutureTask<Integer>(c);
        new Thread(task).start();
        System.out.println("main");
        Integer r = task.get();//相当于join作用 当前线程阻塞等待直到线程执行完毕
        System.out.println(r);

        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<Integer> future = pool.submit(c);
        System.out.println("main");

        Integer r2 = future.get();//当前线程阻塞等待
        System.out.println(r2);

    }


}
