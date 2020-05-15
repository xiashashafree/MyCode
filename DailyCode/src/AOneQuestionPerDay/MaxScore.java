package AOneQuestionPerDay;

import java.util.Scanner;

public class MaxScore {

    private static int maxScore(int[] score,int index1,int index2){
        if(index1>index2){
            int temp= index1;
            index1 = index2;
            index2 = temp;
        }
        int max = score[index1-1];
        for(int i=index1;i<index2;i++){
            if(score[i]>max){
                max = score[i];
            }
        }
        return max;
    }
    private static int modify(int[] score,int id,int grade){
        score[id-1] = grade;
        return score[id-1];
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int stuNum = sc.nextInt();
            int op = sc.nextInt();
            int[] score = new int[stuNum];

            for(int i=0; sc.hasNext() && i<stuNum; i++){
                score[i] = sc.nextInt();

            }
            for(int i=0; sc.hasNext() && i< op; i++){
                String c =sc.next();
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(c.equals("Q")){
                    System.out.println(maxScore(score,a,b));
                }else{
                    modify(score,a,b);
                }
            }
        }
    }


}
