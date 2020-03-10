import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.LinkedList;

class BTNode{
    int val;
    BTNode left;
    BTNode right;
    public BTNode(int val){
        this.val=val;
    }
}



public class BTree {


    private BTNode root=null;
    public BTree(){

        BTNode n1=new BTNode(1);
        root=n1;
        BTNode n2=new BTNode(2);
        BTNode n3=new BTNode(3);
        BTNode n4=new BTNode(4);
        BTNode n5=new BTNode(5);
        BTNode n6=new BTNode(6);

        n1.left=n2;
        n1.right=n4;
        n2.left=n3;
        n4.left=n5;
        n4.right=n6;
    }



    public void preOrder(){
        System.out.print("先序遍历：");
        preOrder(root);
        System.out.println();
    }

    public void inOrder(){
        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();
    }

    public void postOrder(){
        System.out.print("后序遍历：");
        postOrder(root);
        System.out.println();
    }


    public int getNodeCount(){
        return getNodeCount(root);
    }

    public int getLeafCount(){
        return getLeafCount(root);
    }
    public int getKthNodeCount(int k){
        return getKthNodeCount(root,k);
    }

    public int getDepth(){
        return getDepth(root);
    }

    private void preOrder(BTNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void inOrder(BTNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }

    private void postOrder(BTNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }

    /**返回二叉树的总结点数*/
    private int getNodeCount(BTNode root){
        if(null==root){

            return 0;
        }
        //左子树结点数+右子树结点树+1（现结点）
        return getNodeCount(root.left)+getNodeCount(root.right)+1;
    }

    /**返回二叉树的深度*/
    private int getDepth(BTNode root){
        if(null==root){
            return 0;
        }
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }

    /**返回二叉树的叶子结点数*/
    private int getLeafCount(BTNode root){

        //树为空
        if(null==root){
            return 0;
        }

        //判断是否为叶子结点
        if(root.left==null&&root.right==null){
            return 1;
        }

        //左子树的叶子结点个数+右子树的叶子结点个数
        return getLeafCount(root.left)+getLeafCount(root.right);

    }

    //返回第K层的结点数
    private int getKthNodeCount(BTNode root,int k){

        if(root==null||k<1){
            return 0;
        }

        //第一层
        if(k==1){
            return 1;
        }
        //到root的子树中求k-1层的结点
        return getKthNodeCount(root.left,k-1)+getKthNodeCount(root.right,k-1);

    }

    public void hhh(){
         Queue<BTNode> q1=new LinkedList<>();
         q1.offer(root);

         while(q1.size()>0){

             BTNode node=q1.poll();
             System.out.print(node.val+" ");
             if(node.left!=null){
                 q1.offer(node.left);
             }
             if(node.right!=null){
                 q1.offer(node.right);
             }
         }

    }


    public List<Integer> preorderTraversal() {
          if(root==null){return null;}
        List<Integer> l=new ArrayList<>();
          Stack<BTNode> s=new Stack<>();
          BTNode node=root;
          int i=2;
        while(i>=1) {
            while(node!=null){
                l.add(node.val);
                s.push(node);
                node=node.left;
            }
i--;
            while(s.size()>0){
                BTNode n=s.pop();
                if(n.right!=null){
                    l.add(n.right.val);
                }
            }
            node=root.right;
        }


        return l;
    }

    public List<Integer> inorderTraversal() {
        if(root==null){return null;}
        List<Integer> l=new ArrayList<>();
        Stack<BTNode> s=new Stack<>();

        s.push(root);
        BTNode node=root;
        while(node.left!=null){
            node=s.peek();
            if(node.right!=null){
                s.push(node.right);
            }
            if(node.left!=null){
                s.push(node.left);
            }
        }

        while(s.size()>0){
            node=s.pop();
            l.add(node.val);
            if(node.right!=null){
                s.push(node.right);
            }
            if(node.left!=null){
                s.push(node.left);
            }
        }
        Boolean ii=false;
        return l;
    }

    public static void main(String[] args) {
        BTree t=new BTree();
//        t.preOrder();
//        t.inOrder();
//        t.postOrder();
//        System.out.println("总结点数："+t.getNodeCount());
//        System.out.println("叶子结点数："+t.getLeafCount());
//        System.out.println("第K层结点数："+t.getKthNodeCount(3));
//        System.out.println("深度："+t.getDepth());
//        t.hhh();
//        Queue<BTNode> q=new LinkedList<>();
////        q.offer(null);
//        List<Integer> list=t.inorderTraversal();
//
//        for (int i:list
//             ) {
//            System.out.println(i);
//        }

    }
}
