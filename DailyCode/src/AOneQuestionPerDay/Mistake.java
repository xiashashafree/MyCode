package AOneQuestionPerDay;

import java.util.HashMap;
import java.util.Scanner;

public class Mistake {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<>();
        while(sc.hasNext()){
            if(map.size()>8){
                break;
            }
            String next = sc.nextLine();
            String[] s = next.split(" ");
            String file = s[0];
            String line = s[1];
            if(file.contains("\\")){
                file = file.substring(file.lastIndexOf("\\")+1);
                if(file.length()>16){
                    int index = file.length()-16;
                    file = file.substring(index,file.length());
                }
            }
            file = file+" "+line;
            map.put(file,map.getOrDefault(file,0)+1);


        }
        sc.close();
        for(String s:map.keySet()){
            System.out.println(s+" "+map.get(s));
        }

    }


        private static int got(int[][] ways,int[] goods){
            for(int i=1;i<ways.length;i++){
                for(int j = 0;j<=40;j++){
                    ways[i][j] = ways[i-1][j];//不选择第i件物品
                    int x = j-goods[i];//拿了第K件物品
                    if(x>=0){
                        ways[i][j]+=ways[i-1][x];
                    }
                }
            }
            return ways[ways.length-1][40];
        }

        public static void main1(String []args){

            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int sum = sc.nextInt();
                int[][] ways = new int[sum+1][41];
                int[] goods = new int[sum+1];
                for(int i=1;i<=sum;i++){
                    goods[i] = sc.nextInt();
                }
                for(int i=0;i<=sum;i++){
                    ways[i][0] = 1;//n件物品凑出0体积，只有不选这一种方式。
                }

                System.out.println(got(ways,goods));

            }
    }
}
