package lesson1;

import java.util.*;

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
        while(sc.hasNext()){
            String[] P = sc.next().split("\\.");
            String[] A = sc.next().split("\\.");
            for(String s:P){
                System.out.println(s);
            }
            System.out.println(P.length);
            int[] arrP = new int[3];
            int[] arrA = new int[3];
            for(int i=0;i<3;i++){
                arrP[i] = Integer.parseInt(P[i]);
                arrA[i] = Integer.parseInt(A[i]);
            }
            int sumA = ((arrA[0]*17)+arrA[1])*19+arrA[2];

            int sumP =  ((arrP[0]*17)+arrP[1])*19+arrP[2];

            System.out.println(sumA+" "+sumP);
            int rest = sumA - sumP;
            int G = rest/(17*19);
            rest-= G*17*19;
            int S = rest/19;
            rest-= S*19;
            int K = rest;
            System.out.println(G+"."+S+"."+K);

        }
    }
}
