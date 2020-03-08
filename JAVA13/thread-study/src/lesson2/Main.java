package lesson2;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
public class Main {

    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();

        new Thread(new MyRunnable()).start();
    }
}
