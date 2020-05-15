package AOneQuestionPerDay;
import java.util.*;
public class BuyOrNot {



        private static void ret(String red,String buy){
            HashMap<Character,Integer> map = new HashMap<>();
            for(char c:buy.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            int count = 0;//记录缺的珠子的个数
            for(char c:red.toCharArray()){
                if(!map.containsKey(c)){
                    count++;
                }else{
                    map.put(c,map.get(c)-1);
                    if(map.get(c) == 0){
                        map.remove(c);
                    }
                }
            }
            if(count > 0){
                System.out.println("No"+" "+count);
            }else{
                int sum = 0;
                for(char c:map.keySet()){
                    sum =sum+map.get(c);
                }
                System.out.println("Yes"+" "+sum);
            }
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String buy = sc.nextLine();
                String red = sc.nextLine();
                ret(red,buy);
            }
        }

}
