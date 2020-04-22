package OJPratice;
import java.util.Scanner;

public class Main {

//    public static int count(String s1,String s2){
////        int count=0;
////        for (int i = 0; i < s1.length(); i++) {
////            StringBuilder sb=new StringBuilder(s1);
////            sb.insert(i,s2);
////            int left=0;
////            int right=sb.length()-1;
////            while(left<right){
////                if(sb.charAt(left)!=sb.charAt(right)){
////                    break;
////                }
////                left++;
////                right--;
////            }
////            if(left>=right){
////                count++;
////            }
////
////        }
////        return count;
////
////    }

    public static int Coke(int bottle){
        int count=0;
        while(bottle>=2){
            bottle=bottle-2;
            count++;
        }
        return count;
    }

    public static  int count(int[] A, int n) {
        int count=n-1;
        for(int i=0;i<n-1;i++){
            if(A[i]<A[i+1]){
                count--;
            }
        }
        return count;

    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a  = in.nextInt();
//
//            System.out.println(Coke(a));
//        }

        int[] A={3,1,2};

        System.out.println(count(A,3));
    }
}