package lesson2;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class PrinterWriterTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(s.nextInt() == 0){
                        throw new RuntimeException("i = 0");
                    }
                    System.out.println();
                } catch (RuntimeException e) {
                    StringWriter sw=new StringWriter();
                    PrintWriter pw =new PrintWriter(sw);
                    e.printStackTrace(pw);
                    System.out.println(sw.toString());
                }
            }
        }).start();
    }
}
