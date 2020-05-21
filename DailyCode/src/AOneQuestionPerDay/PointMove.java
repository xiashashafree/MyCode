package AOneQuestionPerDay;

import java.util.Scanner;

public class PointMove {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int x = 0;
            int y = 0;
            String[] s = sc.nextLine().split(";");
            for(String s1:s){
                if(s1.length()>0 && s1.length()<4){

                    char c1 = s1.charAt(0);
                    char c2 ='0';
                    char c3 = '0';
                    if(s1.length()>1){
                        c2 = s1.charAt(1);
                        if(c2<'0' || c2>'9')
                            continue;
                    }
                    if(s1.length()>2){
                        c3 = s1.charAt(2);
                        if(c2<'0' || c2>'9')
                            continue;
                    }



                    int num = 0;
                    if(s1.length() == 2){
                        num = Integer.parseInt(c2+"");
                    }else{
                        num = Integer.parseInt(c2+""+c3+"");
                    }

                    if(c1 == 'A'){
                        x = x-num;
                    }else if(c1 == 'D'){
                        x = x+num;
                    }else if(c1 == 'W'){
                        y = y+num;
                    }else if(c1 == 'S'){
                        y = y-num;
                    }


                }
            }
            System.out.println(x+","+y);
        }
    }
}
