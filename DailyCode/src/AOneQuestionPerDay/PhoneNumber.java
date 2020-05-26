package AOneQuestionPerDay;

import java.util.*;
public class PhoneNumber{
    private static String ret(String s){
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='A'&&ch[i]<='C'){
                ch[i] = '2';
            }else if(ch[i]>='D'&&ch[i]<='F'){
                ch[i] = '3';
            }else if(ch[i]>='G'&&ch[i]<='I'){
                ch[i] = '4';
            }else if(ch[i]>='J'&&ch[i]<='L'){
                ch[i] = '5';
            }else if(ch[i]>='M'&&ch[i]<='O'){
                ch[i] = '6';
            }else if(ch[i]>='P'&&ch[i]<='S'){
                ch[i] = '7';
            }else if(ch[i]>='T'&&ch[i]<='V'){
                ch[i] = '8';
            }else if(ch[i]>='W'&&ch[i]<='Z'){
                ch[i] = '9';
            }
        }
        return new String(ch);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            TreeSet<String> set = new TreeSet<>();
            for(int i=0;i<num;i++){
                String s = sc.next().replace("-","");
                set.add(ret(s));
            }
            for(String s:set){
                for(int i=0;i<s.length();i++){
                    System.out.print(s.charAt(i));
                    if( i==2){
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
