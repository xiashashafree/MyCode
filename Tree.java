import java.util.*;
import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class Tree {
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret=new ArrayList<>();

        if(root==null){
            return ret;
        }
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=root;

        while(cur!=null||!s.empty()){
            if(cur!=null){
                s.push(cur);
                cur=cur.left;
            }else{
                cur=s.pop();
                ret.add(cur.val);
                cur=cur.right;
            }
        }
        return ret;

    }

    //二叉树的完全性检验
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean bool=false;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(bool){
                if(cur.left!=null||cur.right!=null){
                    return false;
                }

            }else{
                if(cur.left!=null&&cur.right!=null){
                    q.offer(cur.left);
                    q.offer(cur.right);
                }else if(cur.right!=null){
                    return false;
                }else if(cur.left!=null) {
                    //它的子树也不能有孩子
                    q.offer(cur.left);
                    bool=true;
                }else{
                    bool=true;
                }

            }
        }
        return true;
    }
}
