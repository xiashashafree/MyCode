package AOneQuestionPerDay;

import java.util.*;
public class OldKeyboard{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            String right = s.nextLine().toUpperCase();
            String wrong = s.nextLine().toUpperCase();
            Set<Character> map = new HashSet<>();
            for(char c:wrong.toCharArray()){
                map.add(c);
            }
            for(int i =0;i<right.length();i++){
                char ch = right.charAt(i);
                if(!map.contains(ch)){
                    map.add(ch);
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}