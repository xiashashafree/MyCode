package lesson2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

    // 如何设置线程池的线程数：可以根据 单个任务量，主机配置，环境（系统中运行的其他程序）
    //单个主机运行的主任务是本程序，推荐任务数量根据处理器核数来决定
    private static int COUNT=Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        //数量为1的固定
        ExecutorService pool= Executors.newSingleThreadExecutor();

        //只含有固定数量的正式线程，没有临时工
        ExecutorService pool2=Executors.newFixedThreadPool(2);

        //缓存的线程池，只有临时工，没有正式工
        ExecutorService pool3=Executors.newCachedThreadPool();

        //定时任务的线程池：有正式员工，也有临时工
        ExecutorService pool4=Executors.newScheduledThreadPool(4);

    }
}
