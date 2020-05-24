package AOneQuestionPerDay;
import java.util.Scanner;
public class Decode {


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String s = sc.nextLine();
                char[] p = s.toCharArray();

                for(char c:p){
                    if(c>='a'&&c<='z'){
                        c+=33;
                        if(c =='{'){
                            c='A';
                        }
                        System.out.print(c);
                    }else{
                        c-=31;
                        if(c =='['){
                            c='a';
                        }
                        System.out.print(c);
                    }

                }
                System.out.println();

            }
        }

    public static void main1(String[] args) {
        char c = 'a'+22;

        System.out.println(c);
    }

}
