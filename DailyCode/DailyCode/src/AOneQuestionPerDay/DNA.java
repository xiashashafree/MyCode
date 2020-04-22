package AOneQuestionPerDay;

import java.util.Scanner;
public class DNA{
    private static String ret(String s,int len){
        String result = null;
        int count = 0;
        int lastCount = 0;

        for(int i=0;i<s.length();i++){
            count = 0;
            int j =i;
            for( ;j<i+len && j<s.length();j++){
                char ch=s.charAt(j);
                if(ch == 'C' || ch == 'G'){
                    count++;
                }
            }

            if(count>lastCount){
                result = s.substring(i,j);
                lastCount = count;
            }

        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            int len = sc.nextInt();
            System.out.println(ret(s,len));
        }
    }
}