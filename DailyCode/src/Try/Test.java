package Try;

import java.util.Comparator;
import java.util.PriorityQueue;
//Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Test {

    //  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>(){
                @Override
                public int compare(ListNode n1,ListNode n2){
                    return n1.val-n1.val;
                }
            });
            for(ListNode head:lists){
                while(head != null){
                    q.offer(head);
                    head = head.next;
                }
            }

            ListNode head = new ListNode(-1);
            ListNode cur = head;
            while(!q.isEmpty()){
                cur.next = q.poll();
                cur =  cur.next;
            }
            cur.next = null;
            return head.next;
        }
    private boolean isTree(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return  isTree(t1.left,t2.left) && isTree(t1.right,t2.right);

    }
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1.val == t2.val && isTree(t1,t2)){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
    }
    //分割链表
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ret = new ListNode[k];
        int len= 0;
        ListNode cur = root;
        while(cur!=null){
            cur = cur.next;
            ++len;
        }
        int count = len/k;
        int rest = len%k;
        cur = root;
        for(int i=0;i<k&&cur!=null;i++){
            ret[i] = cur;
            int cursize = count+(rest-- >0 ? 1:0);//余数是否被分配完
            for(int j=0;j<cursize-1;j++){
                cur = cur.next;
            }
            ListNode curnext = cur.next;
            cur.next = null;
            cur = curnext;
        }
        return ret;


    }

}
