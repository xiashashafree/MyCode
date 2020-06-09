package Algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角矩阵，求其从上到下的最小路径和
 */
public class TriangleMtrix {

    /**
     *   1.从上到下
     *     F(i,j):从(0,0)到(i,j)的最小距离
     *     第1列：F(i,j) = F(i-1,j)+a[i,0];
     *     最后1列：F(i,j) = F(i-1,j-1)+a[i,j];
     *     中间列：F(i,j) = main(F(i-1,j-1),F(i-1,j))+a[i,j];
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        List<List<Integer>> sum = new ArrayList<>();
        int size = triangle.size();
        for(int i=0;i<size;i++){
            sum.add(new ArrayList<>());
        }
        //初始化：F(0,0)=a[0,0]
        sum.get(0).add(triangle.get(0).get(0));

        for(int i=1;i<size;i++){
            int cursum = 0;
            for(int j=0;j<=i;j++){

                //第一列
                if(j == 0){
                    cursum = sum.get(i-1).get(0);
                }else if(j == i){
                    //最后一列
                    cursum = sum.get(i-1).get(j-1);
                }else{
                    //中间列
                    cursum = Math.min(sum.get(i-1).get(j),sum.get(i-1).get(j-1));
                }
                sum.get(i).add(cursum+triangle.get(i).get(j));
            }
        }
        int min = sum.get(size-1).get(0);
        for(int i=1;i<size;i++){
            if(sum.get(size-1).get(i)<min){
                min = sum.get(size-1).get(i);
            }
        }
        return min;
    }

    /**
     * F(i,j):(i,j)到最后一列的最小距离
     * 初始化:最后一列到最后一列的最小距离即为a[i,j]本身
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        //F(i,j):(i,j)到最后一列的最小距离
        //初始化:最后一列到最后一列的最小距离即为a[i,j]本身
        int size = triangle.size();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = triangle.get(size-1).get(i);
        }
        for(int i=size-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                arr[j] = Math.min(arr[j],arr[j+1])+triangle.get(i).get(j);
            }
        }
        return arr[0];
    }
}
