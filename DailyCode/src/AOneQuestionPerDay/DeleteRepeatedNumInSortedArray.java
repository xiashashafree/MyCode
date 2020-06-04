package AOneQuestionPerDay;

public class DeleteRepeatedNumInSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int index = 0;//记录不重复区间的最右下标
        for(int i=0;i<nums.length;i++){
            while(i+1<nums.length && nums[i] == nums[i+1]){
                i++;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
