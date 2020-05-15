package lesson1;

import java.util.*;
public class Main{
    private static int gcd(int a,int b){
        int c;
        while(b!=0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int game(int power,int[] monster,int index){
        if(index>=monster.length){
            return power;
        }
        if(monster[index]<=power){
            return game(power+monster[index],monster,index++);
        }
            power = power+gcd(monster[index],power);
            return game(power,monster,index++);

    }


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



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int power = sc.nextInt();
            int[] monster = new int[num];
            for(int i=0;i<num;i++){
                monster[i] = sc.nextInt();
            }
            System.out.println(game(power,monster,0));
        }
    }
}

