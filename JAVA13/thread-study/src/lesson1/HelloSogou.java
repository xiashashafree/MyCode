package lesson1;

public class HelloSogou {
//    public static synchronized void main(String[] a){
//        Thread t =new Thread(){
//            public void run(){
//                Sogou();
//            }
//        };
//        t.run();
//        System.out.println("Hello");
//
//    }
//
//    static synchronized  void Sogou(){
//        System.out.println("Sogou");
//    }

    public static void main(String[] args)throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    throw new RuntimeException();
                }
                System.out.println("2");


            }
        });

        t.start();

        t.join();

        System.out.println("1");

    }
}
