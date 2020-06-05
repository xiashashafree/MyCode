package free;

public class SynchronizedTest {
    public static synchronized void t1(){

    }
    public static synchronized void t2(){
              t1();
    }

    public static void main(String[] args) {
        new Thread(()->{t2();}).start();
    }
}
