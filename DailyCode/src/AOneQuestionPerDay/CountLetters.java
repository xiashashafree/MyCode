package AOneQuestionPerDay;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 统计A-Z的出现个数
 */
public class CountLetters {


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                TreeMap<Character,Integer> map = new TreeMap<>();
                String str = sc.nextLine();
                char[] ch = str.toCharArray();
                for(int i=65;i<=90;i++){
                    char c = (char)(i);
                    map.put(c,0);
                }
                for(char c:ch){
                    if(c>='A' && c<='Z'){
                        map.put(c,map.getOrDefault(c,0)+1);
                    }
                }
                for(char key:map.keySet()){
                    System.out.println(key+":"+map.get(key));
                }
            }
        }

    }
