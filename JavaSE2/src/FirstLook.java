public class FirstLook {

//    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(88888L);
//    }
public static void main(String[] args) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(88888L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
 }
}
