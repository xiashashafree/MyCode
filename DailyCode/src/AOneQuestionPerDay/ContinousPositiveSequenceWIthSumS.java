package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

public class ContinousPositiveSequenceWIthSumS {
    public int[] addList(int small,int big){
        int[] arr = new int[big-small+1];
        int index = 0;
        for(int i=small;i<=big;i++){
            arr[index++] = i;
        }
        return arr;
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> ret = new ArrayList<>();
        int small = 1;
        int big = 2;
        int mid = (target+1)>>1;
        int curSum = small+big;

        //当small的值是mid时，small+big肯定比target大，
        // small和small后面的任意序列的和一定大于target（题意是连续正数序列）
        while(small < mid){
            if(curSum == target){
                ret.add(addList(small,big));
            }

            //curSum大于target时，small前移
            while(curSum>target && small<mid){
                curSum-=small;
                small++;
                if(curSum == target){
                    ret.add(addList(small,big));
                }
            }

            //curSum大于target时，big后移
            big++;
            curSum+=big;
        }
        //new int[0][] 只是为了指定函数的形参数
        //最终返回的数组长度是由你的List存储内容的长度决定的
        //给定0是为了节省空间，因为只是为了说明返回的类型
        return ret.toArray(new int[0][]);

    }
}
