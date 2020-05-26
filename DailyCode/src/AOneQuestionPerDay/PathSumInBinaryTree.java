package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.HashMap;

public class PathSumInBinaryTree {


     public static class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }


        ArrayList<ArrayList<Integer>> ret  = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        private void find(TreeNode root,int target){
            if(root == null){
                return;
            }
            list.add(root.val);
            target = target-root.val;
            if(0 == target && root.left == null && root.right == null){
                ret.add(new ArrayList<>(list));
            }
            if(root.left != null){
                find(root.left,target);
            }
            if(root.right != null){
                find(root.right,target);
            }

            list.remove(list.size()-1);
            HashMap map = new HashMap();

        }
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {



            find(root,target);
            return ret;

        }

}
