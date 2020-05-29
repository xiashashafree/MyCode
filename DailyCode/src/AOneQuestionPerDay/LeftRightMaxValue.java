package AOneQuestionPerDay;
import java.util.*;
public class LeftRightMaxValue {



        public static int findMaxGap(int[] A, int n) {
            // write code here
            int[] left = new int[A.length-1];//左半区间
            int[] right = new int[A.length-1];//右半区间
            left[0] = A[0];
            right[right.length-1] = A[A.length-1];
            for(int i=1;i<left.length;i++){
                if(A[i]>left[i-1]){
                    left[i] = A[i];
                }else{
                    left[i] = left[i-1];
                }
            }
            for(int i=A.length-2;i>=1;i--){
                if(A[i]>right[i]){
                    right[i-1] = A[i];
                }else{
                    right[i-1] = right[i];
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i=0;i<left.length;i++){
                int num = Math.abs(left[i]-right[i]);
                if(num>max){
                    max = num;
                }
            }
            return max;
        }

    public static void main(String[] args) {
        int[] num = {28,75,38,44,66,1};
        findMaxGap(num,6);
    }

}
