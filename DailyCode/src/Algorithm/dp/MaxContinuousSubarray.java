package Algorithm.dp;

public class MaxContinuousSubarray {
    private static int ret(int[] array){
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,3,4,-2,3,4};
        System.out.println(ret(arr));
    }
}
