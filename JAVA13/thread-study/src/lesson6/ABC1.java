package lesson6;

public class ABC1 {


    public static void main(String[] args) throws InterruptedException {
//        Thread t1,t2=null,t3;
//         t1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    synchronized (ABC.class){
//                        System.out.print("A");
//
//                    }
//                }
//
//
//            }
//        });
//         t2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    synchronized (ABC.class){
//                        while(sum!=2){
//                            try {
//                                ABC.class.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        System.out.print("B");
//                        sum=1;
//                        ABC.class.notifyAll();
//
//
//
//
//                    }
//                }
//
//
//
//            }
//        });
//
//        t3=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    synchronized (ABC.class){
//                        while(sum!=1){
//                            try {
//                                ABC.class.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        sum=3;
//                        System.out.println("C");
//                        ABC.class.notifyAll();
//                    }
//                }
//
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//

    }
}
