import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        int[][] gird=new int[3][3];
        int count=1;
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                gird[i][j]=count;
                count++;

            }
        }
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.print(gird[i][j]+" ");
            }
            System.out.println();
        }
        int[] arr=new int[9];
         count=0;
         int k=2;
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                k=k%arr.length;
                arr[k++]=gird[i][j];
//               arr[count]=gird[i][j];
//               count++;

            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
//        List<List<Integer>> list=new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//
//
//        }

    }
}
