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
    private void dfs(TreeNode root,List<Integer> sb){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sb.add(root.val);
            return;
        }
        if(root.left!=null){
            dfs(root.left,sb);
        }
        if(root.right!=null){
            dfs(root.right,sb);
        }
    }
    //叶子相似的书
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        List<Integer> l1 = new ArrayList<>();
        dfs(root1,l1);
        List<Integer> l2 = new ArrayList<>();
        dfs(root2,l2);
        if(l1.size()!=l2.size())
            return false;
        for(int i=0;i<l1.size();i++){
            if(l1.get(i) != l2.get(i)){
                return false;
            }
        }
        return true;
    }
    //层数最深的叶子结点和
    int ans = 0;
    int maxdep = -1;
    private void dfs(TreeNode root,int depth){
        if(root == null){
            return;
        }

        if(depth>maxdep){
            maxdep = depth;
            ans = root.val;

        }else if(maxdep == depth){
            ans+=root.val;
        }


        dfs(root.left,depth+1);


        dfs(root.right,depth+1);

    }
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return -1;
        }

        dfs(root,1);
        return ans;
    }
}
