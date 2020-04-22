package lesson1;



public class ThreadHomeWork {
     public volatile static int ticket = 100;

     private volatile static int sum = 0;

    public static void test1() {
        for (int i = 0; i <5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                      for(int j = 0;j< 200000;j++){
                          synchronized (ThreadHomeWork.class){
                              sum=sum+1;
                          }

                      }
                }
            }).start();
        }
    }

    private static class Buy implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                synchronized (ThreadHomeWork.class){
                    try {
                        while(ticket == 0){
                            ThreadHomeWork.class.wait();
                        }
                        ticket--;
                        ThreadHomeWork.class.notifyAll();
                        System.out.println("卖出一张票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }

    private static class Tui implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                synchronized (ThreadHomeWork.class){
                    ticket++;

                    System.out.println("退了一张票");
                }
            }

        }
    }

    public static void test2(){

        for (int i = 0; i < 30; i++) {
            new Thread(new Buy()).start();
        }
        for (int i = 0; i < 10 ; i++) {
            new Thread(new Tui()).start();
        }
    }

    public static void main(String[] args) {

        test2();
        while(Thread.activeCount()>1){
            Thread.yield();
        }




    }
}
