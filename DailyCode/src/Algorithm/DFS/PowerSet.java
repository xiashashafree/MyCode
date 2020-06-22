package Algorithm.DFS;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private void dfs(List<List<Integer>> ret, List<Integer> solution, int index , int[] nums){
        ret.add(new ArrayList<>(solution));//空集在此添加
        for(int i=index;i<nums.length;i++){
            solution.add(nums[i]);
            dfs(ret,solution,i+1,nums);
            solution.remove(solution.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        dfs(ret,solution,0,nums);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        PowerSet main = new PowerSet();
        List<List<Integer>> ret = main.subsets(nums);
        for (List<Integer> l:ret) {
            for (int i:l) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
