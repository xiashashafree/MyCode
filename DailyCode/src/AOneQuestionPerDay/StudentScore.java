package AOneQuestionPerDay;

import java.util.Scanner;

public class StudentScore{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int sum = sc.nextInt();
            int[] table = new int[sum];
            for(int i=0; i<sum; i++){
                table[i] = sc.nextInt();
            }
            int score = sc.nextInt();
            int count = 0;
            for(int i=0; i<table.length; i++){
                if(table[i] == score){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}