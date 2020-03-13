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
    //最小深度
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);

        if(root.left==null||root.right==null){
            return left+right+1;
        }

        return Math.min(left,right)+1;


    }

    //层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>  ret=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            double sum=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode n=q.poll();
                sum=sum+n.val;
                if(n.left!=null){
                    q.offer(n.left);
                }
                if(n.right!=null){
                    q.offer(n.right);
                }
            }
            ret.add(sum/size);

        }
        return ret;
    }

    //后序非递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=root;

        TreeNode prev=null;
        while(cur!=null||!s.empty()){

            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            TreeNode node=s.peek();

            if(node.right==null||node.right==prev){
                ret.add(node.val);
                prev=node;
                s.pop();

            }else{
                cur=node.right;
            }


        }

        return ret;

    }
}
