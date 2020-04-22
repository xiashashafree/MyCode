package lesson1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main{
    public static int ret(List<Integer> l){
        int index=0;
       while(l.size()>1){
           index = (index+2)%l.size()-1;
           l.remove(index);

       }
       return 0;
    }
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            List<Integer> l=new LinkedList<>();
            int len = sc.nextInt();

            for(int i=0; i<len; i++){
                l.add(i);
            }
            System.out.println(ret(l));
        }


    }
}
