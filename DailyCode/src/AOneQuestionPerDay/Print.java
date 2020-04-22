package AOneQuestionPerDay;

import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.Scanner;

public class Print {
   static boolean out(char c){
       System.out.println(c);
       return true;
   }

    public static void main(String[] args) {
//        int  i =0;
//        for (out('A');out('B') &&i<2;out('C')) {
//               i++;
//               out('D');
//        }
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            String s = sc.next();
            System.out.println(num+s);
        }


    }
}
