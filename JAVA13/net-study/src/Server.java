import javafx.print.Printer;
import sun.print.PrinterJobWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static int PORT=9000;
    private static final ExecutorService  POOL = Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while(true){
            Socket client = server.accept();
            POOL.execute(new Task(client));
        }
    }

    private static class Task implements  Runnable{
        private Socket client;

        private Task(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                String str;
                while((str = in.readLine()) != null){
                    System.out.println(str);
                    out.println("确实牛逼");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
