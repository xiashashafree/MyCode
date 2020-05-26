package AOneQuestionPerDay;

/**
 * 求矩阵中最小和路径
 * 每次只能向右移动一个或向下移动一格
 * 动态规划
 */
public class MinMatrix {
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
        //建立路径和数组
        int[][] dp = new int[grid.length][grid[0].length];
        //对于第一行的dp[0][j]值为：gird[0][0]+...+gird[0][j];
        int sum = 0;
        for(int j=0;j<grid[0].length;j++){
            sum = sum+grid[0][j];
            dp[0][j] = sum;
        }
        sum = 0;
        //对于第一列的dp[0][j]值为：gird[0][0]+...+gird[i][0];
        for(int i=0;i<grid.length;i++){
            sum = sum+grid[i][0];
            dp[i][0] = sum;
        }

        //对于i>0 j>0的 dp[i][j] = （上面的值和下面的值中最小的一个）+grid[i][j]
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] num = {{1,2,3},{2,-1,2},{3,2,1}};
        minPathSum(num);
    }

}
