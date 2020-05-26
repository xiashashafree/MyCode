package AOneQuestionPerDay;

//打印方向	1. 根据边界打印	2. 边界向内收缩	3. 是否打印完毕
//从左向右	左边界l ，右边界 r	上边界 t 加 11	是否 t > b
//从上向下	上边界 t ，下边界b	右边界 r 减 11	是否 l > r
//从右向左	右边界 r ，左边界l	下边界 b 减 11	是否 t > b
//从下向上	下边界 b ，上边界t	左边界 l 加 11	是否 l > r
//复杂度分析：
//时间复杂度 O(MN)O(MN) ： M, NM,N 分别为矩阵行数和列数。
//空间复杂度 O(1)O(1) ： 四个边界 l , r , t , b 使用常数大小的 额外 空间（ res 为必须使用的空间）。

public class ClockwisePrintMatrix {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottle = matrix.length-1;
        int[] ret = new int[ (bottle+1) * (right+1)];
        int index = 0;
        while(true){
            for(int i=left;i<=right;i++){
                ret[index++] = matrix[top][i];
            }
            if(++top>bottle) break;
            for(int i=top;i<=bottle;i++){
                ret[index++] = matrix[i][right];
            }
            if(--right<left) break;
            for(int i=right;i>=left;i--){
                ret[index++] = matrix[bottle][i];
            }
            if(--bottle<top) break;
            for(int i=bottle;i>=top;i--){
                ret[index++] = matrix[i][left];
            }
            if(++left>right) break;
        }
        return ret;
    }
}
