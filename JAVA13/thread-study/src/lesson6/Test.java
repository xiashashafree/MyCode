package lesson6;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Test{


    public static void main(String[] args) {
        ExecutorService pool=Executors.newFixedThreadPool(4);//创建线程池，里面有4个线程
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        });

        System.out.println("doing ");
    }

}
