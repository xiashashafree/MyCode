package AOneQuestionPerDay;
import java.util.Scanner;
/***
 *查找字符串中是否有相同长度超2的重复子串
 */
public class RepeatedSubstring {


        public static boolean search(String s){
            if(s.length()<9){
                return false;
            }

            int a = 0;
            int A = 0;
            int num = 0;
            int other = 0;
            for(int i=0;i<s.length();i++){
                if(s.length()>6){
                    int l = i;
                    int right = i+3;
                    if(right<=s.length()){
                        String sub = s.substring(l,right);
                        int index = s.indexOf(sub);
                        int index1 = s.lastIndexOf(sub);
                        if(index != index1){
                            return false;
                        }
                    }
                }

                char c =s.charAt(i);
                if(c>=65 && c<=90){
                    A=1;
                }else if(c>=97 && c<=122){
                    a = 1;
                }else if(Character.isDigit(c)){
                    num = 1;
                }else{
                    other = 1;
                }

            }
            return (a+A+num+other)>2 ? true:false;
        }
        public static void main(String[] args){

            Scanner sc =new Scanner(System.in);
            while(sc.hasNext()){
                String s = sc.nextLine();
                if(search(s)){
                    System.out.println("OK");
                }else{
                    System.out.println("NG");
                }
            }

        }

}
