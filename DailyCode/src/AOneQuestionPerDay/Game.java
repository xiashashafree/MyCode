package AOneQuestionPerDay;

import java.util.Scanner;

public class Game {

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
