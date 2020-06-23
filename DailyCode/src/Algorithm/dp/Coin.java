package Algorithm.dp;

/**
 * 1.深度优先搜索
 * 2.动态规划 DP
 */
public class Coin {

    /**
     * 深度优先：会超时
     */
    int count = 0;
    private void dfs(int[] money,int curSum,int n,int index){
        if(curSum>=n){
            if(curSum == n){
                ++count;

            }

            return;
        }
        for(int i=index;i<money.length;i++){
            dfs(money,curSum+money[i],n,i);

        }
        long i = 1;
        double j = 9;
        j+=1.5;j=j%2;

    }
    public int waysToChange(int n) {
        int[] money = {25,10,5,1};
        count = 0;
        dfs(money,0,n,0);
        return count%1000000007;
    }

    /**
     * 动态规划
     */
//    private void dp()
//    public int waysToChange1(int n){
//
//
//    }
    public static void main(String[] args) {
        double j = 9;
        j+=1.5;j=j%2;

        System.out.println(j);
    }
}
