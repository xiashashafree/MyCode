package OJPratice;
//import java.util.Scanner;
//
//public class Main {
//
////    public static int count(String s1,String s2){
//////        int count=0;
//////        for (int i = 0; i < s1.length(); i++) {
//////            StringBuilder sb=new StringBuilder(s1);
//////            sb.insert(i,s2);
//////            int left=0;
//////            int right=sb.length()-1;
//////            while(left<right){
//////                if(sb.charAt(left)!=sb.charAt(right)){
//////                    break;
//////                }
//////                left++;
//////                right--;
//////            }
//////            if(left>=right){
//////                count++;
//////            }
//////
//////        }
//////        return count;
//////
//////    }
//
//    public static int Coke(int bottle){
//        int count=0;
//        while(bottle>=2){
//            bottle=bottle-2;
//            count++;
//        }
//        return count;
//    }
//
//    public static  int count(int[] A, int n) {
//        int count=n-1;
//        for(int i=0;i<n-1;i++){
//            if(A[i]<A[i+1]){
//                count--;
//            }
//        }
//        return count;
//
//    }
//    public static void main(String[] args) {
//////        Scanner in = new Scanner(System.in);
//////        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//////            int a  = in.nextInt();
//////
//////            System.out.println(Coke(a));
//////        }
////
////        int[] A={3,1,2};
////
////        System.out.println(count(A,3));
//
////
//        byte b1=1,b2=2,b3,b6;
//        final byte b4=4,b5=6;
//        b6=b4+b5;
//        b3=b1+b2;
//    }
//}

import java.util.Scanner;
public class Main{
    public static int ret(int num){
        int f1=0;
        int f2=1;
        int fN1=0;
        int fN2=0;
        while(fN2<num){
            fN1=f1+f2;
            System.out.println("fN1: "+fN1);
            fN2=fN1;
            System.out.println("fN2: "+fN2);
            if(fN2>=num){
                fN1=fN1-f1;
                System.out.println("fN1: "+fN1);
            }
            f1=f2;
            f2=fN1;
        }
        if(num-fN1 < fN2-num){
            return num-fN1;
        }
        return fN2-num;
    }
    public static int countWays1(int x, int y) {
        int sum=x*y;
        if(sum<4){
            return 1;
        }
        if(sum%4 == 0){
            return (sum/4)*2;
        }
        return (sum/4)*2+1;

    }
    public static int countWays(int x,int y){
        if(x<0 || y<0){
            return 0;
        }
        if(x==1 || y==1){
            return 1;
        }
        return countWays(x-1,y)+countWays(x,y-1);
    }

    public static int ways(int[] array,int i,int wight){
        if(wight == 0){
            return 1;
        }
        if( i == 0){
            if(array[0] == wight){
                return 1;
            }
            return 0;
        }
        if(array[i] > wight){
            return ways(array,i-1,wight);
        }
        return ways(array,i-1,wight-array[i]) + ways(array,i-1,wight);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            int[] array = new int[count];

            for(int i=0; i< count; i++){
                array[i] = sc.nextInt();

            }
            System.out.println(ways(array,array.length-1,40));
        }

    }
}