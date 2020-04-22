package lesson7;

import lesson6.BlockingQueue;

public class MyThreadPool {

    private BlockingQueue<Runnable>  queue;

    public MyThreadPool(int size,int capacity){

        queue=new BlockingQueue<>(capacity);
        for (int i = 0; i < size ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            Runnable task=queue.take();
                            task.run();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool=new MyThreadPool(3,10);
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
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
            }
        });
    }
}
