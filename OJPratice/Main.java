package OJPratice;
import java.util.Scanner;

public class Main {

    public static int count(String s1,String s2){
        int count=0;
        for (int i = 0; i < s1.length(); i++) {
            StringBuilder sb=new StringBuilder(s1);
            sb.insert(i,s2);
            int left=0;
            int right=sb.length()-1;
            while(left<right){
                if(sb.charAt(left)!=sb.charAt(right)){
                    break;
                }
                left++;
                right--;
            }
            if(left>=right){
                count++;
            }

        }
        return count;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a  = in.next();
            String b = in.next();
            System.out.println(count(a,b));
        }
    }
}