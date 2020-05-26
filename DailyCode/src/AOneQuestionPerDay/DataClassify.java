package AOneQuestionPerDay;

import java.util.*;
public class DataClassify{
    private static void ret(int[] list){
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        double A4 = 0.0;
        int count4 = 0;
        int A5 = 0;
        int op = 1;
        for(int i:list){
            if(i%2 == 0 && i%5 == 0){
                A1+=i;
            }
            if(i%5 == 1){
                A2 = (op*i)+A2;
                op=-op;
            }
            if(i%5 == 2){
                A3++;
            }
            if(i%5 == 3){
                A4=A4+i;
                ++count4;
            }
            if(i%5 == 4){
                if(i>A5){
                    A5=i;
                }
            }
        }
        double avg = A4/count4;
        if(A1!=0){
            System.out.print(A1+" ");
        }else{
            System.out.print("N"+" ");
        }
        if(A2!=0){
            System.out.print(A2+" ");
        }else{
            System.out.print("N"+" ");
        }
        if(A3!=0){
            System.out.print(A3+" ");
        }else{
            System.out.print("N"+" ");
        }
        if(A4!=0.0){
            System.out.print(String.format("%.1f",avg)+" ");
        }else{
            System.out.print("N"+" ");
        }
        if(A5!=0){
            System.out.print(A5);
        }else{
            System.out.print("N");
        }

    }
    public static void main(String[] args){

        int i =0;
        Scanner input = new Scanner(System.in);
        int sum = input.nextInt();
        int[] array = new int[sum];
        while(i<sum){
            array[i] = input.nextInt();
            i++;
        }
        ret(array);
    }
}

