package OJPratice;


import java.util.Scanner;
public class Main2 {

//    public static int ret(int apple){
//
//
//
//
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while( sc.hasNext()){
//            int apple = sc.nextInt();
//            System.out.println(ret(apple));
//        }
//    }

    public static String ret(String s1,String s2){
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ;i < s1.length(); i++){
            char ch=s1.charAt(i);
            if(!s2.contains(ch+"")){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(ret(s1,s2));

        }
    }

}
