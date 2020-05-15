package AOneQuestionPerDay;

import java.util.*;


 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class BalanceCheck {
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
