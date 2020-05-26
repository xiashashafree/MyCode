package AOneQuestionPerDay;
import java.util.*;
public class Printer {

    /**
     * 二维数组打印 成对角线打印
     * @param arr
     * @param n
     * @return
     */

        public static int[] arrayPrint(int[][] arr, int n) {
            // write code here
            if(arr == null || arr.length==0||arr[0].length == 0){
                return null;
            }
            int index = 0;
            int[] ret = new int[n*n];
            for(int j = n-1;j>=0;j--){
                int i=0;
                int  k =j;
                while(i<n && k<n){
                    ret[index++] = arr[i][k];
                    i++;
                    k++;
                }
            }
            for(int i=1;i<n;i++){
                int j = 0;
                int k=i;
                while(j<n && k<n){
                    ret[index++] = arr[k][j];
                    j++;
                    k++;
                }
            }
            return ret;
        }

    public static void main(String[] args) {
        int [] ret =arrayPrint(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},4);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]+" ");
        }

    }

}
