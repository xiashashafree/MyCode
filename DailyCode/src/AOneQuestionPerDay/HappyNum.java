package AOneQuestionPerDay;

public class HappyNum {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int vote = 1;
        int cur = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == cur){
                vote ++;
            }else{
                vote--;
                if(vote == 0){
                    cur = nums[i];
                    vote=1;
                }

            }
        }
        return cur;
    }
}
