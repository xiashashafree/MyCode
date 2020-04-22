package lesson1;

public class MyBlockingQueue<E>{

    private Object[] array;
    private int takeIndex;
    private int putIndex;
    private int size;

    public MyBlockingQueue(int capacity){
        array= new Object[capacity];
        size = 0;
    }

    public synchronized void put(E e) throws InterruptedException {
        while( size == array.length){
            this.wait();
        }
        array[putIndex] = e;
        size++;
        putIndex = (putIndex+1)%array.length;
        this.notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (size == 0){
            this.wait();
        }
        E e =(E) array[takeIndex];
        takeIndex = (takeIndex+1)%array.length;
        size--;
        this.notifyAll();
        return e;
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 50; j++) {
                        try {

                            queue.put("I love you ❤");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }

        try {
            while(true){
                String s= queue.take();
                System.out.println(s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
