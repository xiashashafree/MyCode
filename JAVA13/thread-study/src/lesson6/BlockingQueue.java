package lesson6;

/**
 * 实现阻塞式队列：
 * 1.满足线程安全的生产、消费的功能
 * 2.生产、消费达到上限/下限时，需要阻塞等待
 */
public class BlockingQueue<E> {

    private Object[] items;
    private int takeIndex;//弹出元素的索引
    private int putIndex;//添加元素的索引
    private int size;//有效元素的个数

    public BlockingQueue(int capacity){
        items=new Object[capacity];

    }

    // 线程间通信，推荐做法：
    // 1.while来判断，不要使用if（因为在判断代码中进行wait释放锁以后，
    // 其他线程会修改变量，再次wait被通知恢复的时候，条件已经不满足了）
    // 2.使用notifyAll方法，通知所有wait被阻塞的线程
    public synchronized void put(E o) throws InterruptedException {

        //使用while:因wait()阻塞的线程被唤醒时，会再次判断条件
        while(size == items.length){//达到上限，需要等待
            wait();
        }
        items[putIndex]=o;
        putIndex=(putIndex+1)%items.length;
        size++;
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while(size == 0){//达到下限，需要等待
            wait();
        }
        size--;
        notifyAll();
        E e=(E)items[takeIndex];
        takeIndex=(takeIndex+1)%items.length;

        return e;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue=new BlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            final int k=i;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try { // 从0-4的5个线程，每个线程循环100次，每次循环添加一个不同的数值
                        for (int j = 0; j < 100; j++) {
                               queue.put(k*100+j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }

        while(true){// 这里可以改为多个线程取，现在这里只是在main线程进行取操作
            // 可以观察下，取出来的数值，是不是从0-499，如果有重复元素，可能就出问题了
            int num = queue.take();
            System.out.println("取出："+num);
        }
    }


}
