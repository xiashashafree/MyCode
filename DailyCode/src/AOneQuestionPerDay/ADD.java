package AOneQuestionPerDay;

import java.util.*;
public class ADD{
    public static String ret(String s1,String s2){
        StringBuilder sb=new StringBuilder();

        int len1=s1.length()-1,len2=s2.length()-1;
        int carry = 0;
        while(len1>=0 && len2>=0){
            int sum = s1.charAt(len1)-'0'+s2.charAt(len2)-'0'+carry;
            if(sum<10){
                sb.append(sum+"");
                carry = 0;
            }else{

                sb.append(sum%10);
                carry=sum/10;
            }
            len1--;
            len2--;
        }
        while(len1>=0){
            int sum = s1.charAt(len1)-'0'+carry;
            if(sum<10){
                sb.append(sum+"");
                carry = 0;
            }else{
                sb.append(sum%10);
                carry=sum/10;
            }
            len1--;
        }
        while(len2>=0){
            int sum = s2.charAt(len2)-'0'+carry;
            if(sum<10){
                sb.append(sum+"");
                carry = 0;
            }else{
                sb.append(sum%10);
                carry=sum/10;
            }
            len2--;
        }
        while(carry!=0){
            sb.append(carry%10);
            carry=carry/10;
        }
        return sb.reverse().toString();



    }

//    public static void main(String args[]){
//
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            System.out.println(ret(s1,s2));
//        }
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        char c = scanner.next().charAt(0);

        for (int i = 0; i < (N + 1) / 2; i++) {
            for (int j = 0; j < N; j++) {
                if(i == 0 || j == 0 || i == ((N+1)/2 - 1) || j == N-1) {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

