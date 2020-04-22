package OJPratice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//public class Main6{
//    public static int ret(int num){
//        if(num == 0 || num == 1){
//            return 0;
//        }
//        int count = 0;
//        for(int i =2;i<=num;i++){
//            int j = i;
//            if(j%5==0)
//                count=count+(j/5);
//
//        }
//        return count;
//
//    }
//    public static void main(String[] rags){
////        Scanner sc = new Scanner(System.in);
////        while(sc.hasNext()){
////            int num = sc.nextInt();
////            System.out.println(ret(num));
////        }
//        List<Integer> l=new ArrayList<>();
//        l.add(1);
//        l.add(2);
//        l.toString();
//        System.out.println(l);
//        String s="jjjj";
//        StringBuffer sb=new StringBuffer(s);
//        sb.reverse();
//    }
//}

public class Main6{
    public static String ret(int num){
        StringBuffer sb = new StringBuffer();
        while(num!=0){
            sb.append(num%10+"");
            num=num/10;
        }
        return sb.toString();

    }
    public static void main(String[] rags){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            System.out.println(ret(num));
        }
    }
}