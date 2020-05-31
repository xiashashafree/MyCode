package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.Scanner;

public class AnSum {

    // res 用于保存最终结果
    static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            // 核心逻辑在此. 注意理解 m, n 的含义.
            // 题目要求是求 1...n 中取若干个数, 和为 m
            dfs(1, m, n);
            // 打印结果集合
            for (ArrayList<Integer> l : res) {
                int i = 0;
                for (; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }

    public static void dfs(int index, int count, int n) {
        if (count == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = index; i <= count && i <= n; i++) {
                list.add(i);
            // 此处进行了递归, 对问题进行拆解.
            // 求 1...n 中取若干个数字和为 m, 能把问题拆解为
            // 求 2...n 中取若干给数字, 和为 m - 1
                dfs(i + 1, count - i, n);
               list.remove(list.size() - 1);//count != 0 此种方法不行，要原路删除
            }
        }
    }

}
