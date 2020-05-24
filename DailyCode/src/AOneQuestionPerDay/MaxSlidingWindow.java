package AOneQuestionPerDay;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindowF(int[] nums, int k) {
        if(nums == null || nums.length<k|| k==0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int lastSum = sum;
        list.add(lastSum);

        for(int i=k;i<nums.length;i++){
            sum = sum-nums[i-k]+nums[i];
            if(sum>lastSum){
                lastSum = sum;
                list.add(sum);
            }else{
                list.add(lastSum);
            }
        }
        int[] ret = new int[list.size()];
        int index = 0;
        for(int i:list){
            ret[index++] = i;
        }
        return ret;
    }

    public static void main(String[] args) {
        maxSlidingWindowF(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
