package Algorithm.dp;

import java.util.Scanner;

public class Bag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();//物品总数
            int bag = sc.nextInt();//背包承重
            int[] w = new int[num];
            int[] price = new int[num];
            for (int i = 0; i < num; i++) {
                w[i] = sc.nextInt();
            }
            for (int i = 0; i < num; i++) {
                price[i] = sc.nextInt();
            }
            int[][] dp = new int[num + 1][bag + 1];
            //初始化状态
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= bag; j++) {
                    //当前物品比当前背包总重要重时：
                    if (w[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + price[i - 1]);
                    }
                }
            }
            System.out.println(dp[num][bag]);
        }
    }
}
