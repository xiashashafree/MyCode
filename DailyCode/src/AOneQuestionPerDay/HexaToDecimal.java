package AOneQuestionPerDay;

import java.util.Scanner;

/**
 * 十六进制转十进制
 */
public class HexaToDecimal {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String num = sc.nextLine();
            num = num.substring(2,num.length());
            char[] ch = num.toCharArray();
            int pow = 0;
            int sum = 0;
            for(int i=ch.length-1;i>=0;i--){
                if(ch[i]>='0' && ch[i]<='9'){
                    int cur = ch[i]-'0';
                    cur =cur*((int)Math.pow(16,pow));
                    sum = sum+cur;
                }else{
                    int cur = ch[i]-'7';
                    cur =cur*((int)Math.pow(16,pow));
                    sum+=cur;
                }
                ++pow;
            }
            System.out.println(sum);
        }
    }

}
