package lesson6;

public class ABC {

    private static volatile  int sum=3;

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (ABC.class){
                        while(sum!=3){
                            try {
                                ABC.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("A");
                        sum=2;
                        ABC.class.notifyAll();
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (ABC.class){
                        while(sum!=2){
                            try {
                                ABC.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        sum=1;
                        ABC.class.notifyAll();

                    }
                }
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (ABC.class){
                        while(sum!=1){
                            try {
                                ABC.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        sum=3;
                        System.out.println("C");
                        ABC.class.notifyAll();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
