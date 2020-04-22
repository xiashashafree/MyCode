package lesson2;

public class UnsafeThread {
    private static final int COUNT=20;
    private static final int NUM=10000;
    static int SUM=0;


    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public  void run() {
                    for (int j = 0; j < NUM ; j++) {
                        SUM++;
                    }
                }
            }).start();

        }

        while(Thread.activeCount()>1){
            Thread.yield();
        }

        System.out.println(SUM);
    }
}
