import java.util.*;
import java.util.LinkedList;

//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }


public class Tree {
//    TreeNode root=null;
//    //中序遍历
//    public Tree(int[]  preorder){
//        bstFromPreorder(preorder);
//    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ret=new ArrayList<>();
//
//        if(root==null){
//            return ret;
//        }
//        Stack<TreeNode> s=new Stack<>();
//        TreeNode cur=root;
//
//        while(cur!=null||!s.empty()){
//            if(cur!=null){
//                s.push(cur);
//                cur=cur.left;
//            }else{
//                cur=s.pop();
//                ret.add(cur.val);
//                cur=cur.right;
//            }
//        }
//        return ret;
//
//    }
//
//    //二叉树的完全性检验
//    public boolean isCompleteTree(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        boolean bool=false;
//
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            TreeNode cur=q.poll();
//            if(bool){
//                if(cur.left!=null||cur.right!=null){
//                    return false;
//                }
//
//            }else{
//                if(cur.left!=null&&cur.right!=null){
//                    q.offer(cur.left);
//                    q.offer(cur.right);
//                }else if(cur.right!=null){
//                    return false;
//                }else if(cur.left!=null) {
//                    //它的子树也不能有孩子
//                    q.offer(cur.left);
//                    bool=true;
//                }else{
//                    bool=true;
//                }
//
//            }
//        }
//        return true;
//    }
//    //最小深度
//    public int minDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        if(root.left==null&&root.right==null){
//            return 1;
//        }
//        int left=minDepth(root.left);
//        int right=minDepth(root.right);
//
//        if(root.left==null||root.right==null){
//            return left+right+1;
//        }
//
//        return Math.min(left,right)+1;
//
//
//    }
//
//    //层平均值
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double>  ret=new ArrayList<>();
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            double sum=0;
//            int size=q.size();
//            for(int i=0;i<size;i++){
//                TreeNode n=q.poll();
//                sum=sum+n.val;
//                if(n.left!=null){
//                    q.offer(n.left);
//                }
//                if(n.right!=null){
//                    q.offer(n.right);
//                }
//            }
//            ret.add(sum/size);
//
//        }
//        return ret;
//    }
//
//    //后序非递归
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> ret=new ArrayList<>();
//        Stack<TreeNode> s=new Stack<>();
//        TreeNode cur=root;
//
//        TreeNode prev=null;
//        while(cur!=null||!s.empty()){
//
//            while(cur!=null){
//                s.push(cur);
//                cur=cur.left;
//            }
//            TreeNode node=s.peek();
//
//            if(node.right==null||node.right==prev){
//                ret.add(node.val);
//                prev=node;
//                s.pop();
//
//            }else{
//                cur=node.right;
//            }
//
//
//        }
//
//        return ret;
//
//    }
//  int index=0;
//    public TreeNode bstFromPreorder(int[] preorder) {
//        TreeNode root=null;
//
//        if(index<preorder.length){
//            root=new TreeNode(preorder[index]);
//            index++;
//            if(index<preorder.length&&preorder[index]<root.val){
//                root.left=bstFromPreorder(preorder);
//
//
//            }
//            index++;
//            if(index<preorder.length&&preorder[index]>root.val){
//                root.right=bstFromPreorder(preorder);
//
//            }
//
//        }
//        return root;
//
//    }
//    private int sum(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        if(root.left==null&&root.right==null){
//            return root.val;
//        }
//        int left=0,right=0;
//        if(root.left!=null){
//            left=sum(root.left);
//        }
//        if(root.right!=null){
//            right=sum(root.right);
//        }
//        return left+right+root.val;
//    }
//
//    //求二叉树的坡度
//    public int findTilt(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int left=0,right=0;
//        if(root.left!=null){
//            left=sum(root.left);
//        }
//        if(root.right!=null){
//            right=sum(root.right);
//        }
//        return Math.abs(left-right)+root.val;
//    }
//
//    //二叉搜素数最近的公共祖先
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        if(p.val<root.val&&q.val<root.val){
//            return lowestCommonAncestor(root.left,p,q);
//        }
//        if(p.val>root.val&&q.val>root.val){
//            return lowestCommonAncestor(root.right,p,q);
//        }
//        return root;
//
//
//    }
//
//    private List<Integer>  inorder(TreeNode root){
//        List<Integer> ret=new ArrayList<>();
//        if(root!=null){
//            inorder(root.left);
//            ret.add(root.val);
//            inorder(root.right);
//        }
//        return ret;
//
//    }
//    public int kthLargest(TreeNode root, int k) {
//        List<Integer> ret=inorder(root);
//        Collections.reverse(ret);
//        return ret.get(k-1);
//    }
//
//    /**单值二叉树*/
//    int val;
//    private boolean hh(TreeNode root){
//        if(root==null){
//            return true;
//        }
//        if(root.val==val){
//            return hh(root.left)&&hh(root.right);
//        }
//        return false;
//
//    }
//    public boolean isUnivalTree(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        val=root.val;
//        return hh(root);
//
//    }
//    /**找第K大的结点值*/
//    List<Integer> ret=new ArrayList<>();
//    private List<Integer>  inorder(TreeNode root){
//
//        if(root!=null){
//            inorder(root.left);
//            ret.add(root.val);
//            inorder(root.right);
//        }
//        return ret;
//
//    }
//    public int kthLargest(TreeNode root, int k) {
//        inorder(root);
//        Collections.reverse(ret);
//        return ret.get(k-1);
//    }
///**普通二叉树的最近祖先节点*/
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null||p==root||q==root){
//            return root;
//        }
//        TreeNode left=lowestCommonAncestor(root.left,p,q);
//        TreeNode right=lowestCommonAncestor(root.right,p,q);
//        if(left==null){
//            return right;
//        }
//        if(right==null){
//            return left;
//        }
//
//        return root;
//    }
//
//
//    /**二叉树的镜像*/
//
//    TreeNode Root;
//    private void exchange(TreeNode Root){
//
//        if(Root==null || Root.left==null&&Root.right==null){
//            return;
//        }
//        if(Root.left==null){
//            Root.left=Root.right;
//            Root.right=null;
//        }else if(Root.right==null){
//            Root.right=Root.left;
//            Root.left=null;
//        }else{
//            TreeNode node=Root.right;
//            Root.right=Root.left;
//            Root.left=node;
//        }
//
//        exchange(Root.left);
//        exchange(Root.right);
//
//
//
//
//    }
//    public TreeNode mirrorTree(TreeNode root) {
//
//        Root=root;
//        exchange(Root);
//        return Root;
//    }
//    /**重构二叉树，左右子树交换*/
//    int index1=0;
//    private TreeNode buildTree(int[] preorder,int[] inorder,int left,int right){
//        if(index1>=preorder.length||left>right){
//            return null;
//        }
//        TreeNode  node=new TreeNode(preorder[index1]);
//        int inIdex=left;
//        while(inIdex<=right){
//            if(inorder[inIdex]==preorder[index1]){
//                break;
//            }
//            inIdex++;
//        }
//
//        index1++;
//
//        node.left=buildTree(preorder,inorder,left,inIdex-1);
//        node.right=buildTree(preorder,inorder,inIdex+1,right);
//
//        return node;
//
//
//
//    }
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return buildTree(preorder,inorder,0,preorder.length-1);
//
//    }
//    public static void main(String[] args) {
////        int[] preOrder={8,5,1,7,10,12};
////         Tree t=new Tree(preOrder);
//        List<Integer> l=new ArrayList<>();
//        l.add(1);
//
//        System.out.println(l.get(0));
//
//    }
//
///**二叉树的前K个最小数*/
//    private PriorityQueue<Integer> order(TreeNode root,PriorityQueue<Integer> q){
//        if(root!=null){
//            q.offer(root.val);
//            order(root.left,q);
//            order(root.right,q);
//        }
//        return q;
//    }
//    public int kthSmallest(TreeNode root, int k) {
//        PriorityQueue<Integer> q=new PriorityQueue<>();
//        order(root,q);
//        while(k>1){
//            q.poll();
//            k--;
//        }
//        return q.peek();
//    }
//    /**完全二叉树的和*/
//    int sum;
//    private void hh(TreeNode root){
//        if(root==null){
//            return;
//        }
//        if(root!=null){
//            sum++;
//        }
//        hh(root.left);
//        hh(root.right);
//    }
//    public int countNodes(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        hh(root);
//        return sum;
//
//
//    }


}
