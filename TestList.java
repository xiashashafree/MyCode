import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static List<List<Integer>> subsets(int[] nums){
          List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 0; i <nums.length ; i++) {
            list.add(new ArrayList<>());
            list.get(list.size()-1).add(nums[i]);

        }


        for (int i = 0; i < nums.length; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < nums.length; j++) {

                if(nums[i]!=nums[j]){
                    list.get(list.size()-1).add(nums[j]);
                }
            }

        }

        list.add(new ArrayList<>());
        for (int i = 0; i <nums.length ; i++) {
            list.get(list.size()-1).add(nums[i]);
        }

        return list;

    }

    public static void main(String[] args) {
        int []  nums={1,2,3};

        List<List<Integer>> list=subsets(nums);
        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();

        }
    }


}
