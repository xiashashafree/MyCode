package lesson2;

import java.util.Scanner;

public class Test {

    private static int[] nextValue(String s){
        int[] next=new int[s.length()];

        //前缀
        int i=-1;
        //后缀
        int j=0;
        next[0]=-1;
        int len=s.length();

        while(j<len-1){
            if(i==-1||s.charAt(i)==s.charAt(j)){
                ++i;
                ++j;
                next[j]=i;
            }else{
                i=next[i];
            }
        }
        return next;
    }

    public static int KMP(String s,String p,int[] next){
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int pLen = p.length();
        while (i < sLen && j < pLen)
        {
            //如果j = -1，或者当前字符匹配成功，都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }else{
                //如果j != -1，且当前字符匹配失败，则 i 不变，j = next[j]
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        else
            return -1;

    }

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
         String s=input.nextLine();
         String p=input.nextLine();
        int[] next=nextValue(p);

        System.out.println(KMP(s,p,next));
    }
}
