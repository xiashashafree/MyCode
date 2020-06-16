package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class TreeNodeToListNode {
    private TreeNode tree(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid = left+((right-left)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = tree(nums,left,mid-1);
        root.right = tree(nums,mid+1,right);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return tree(nums,0,nums.length-1);
    }
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return null;
        }
        List<ListNode> ret = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tree);
        while(!q.isEmpty()){
            int size = q.size();
            ListNode head = new ListNode(-1);
            ListNode node = head;
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                ListNode n = new ListNode(cur.val);
                node.next = n;
                node = node.next;
                if(cur.left!= null){
                    q.offer(cur.left);
                }
                if(cur.right!= null){
                    q.offer(cur.right);
                }

            }
            ret.add(head.next);
        }
        ListNode[] arr = new ListNode[ret.size()];
        int index = 0;
        for(ListNode node:ret){
            arr[index++] = node;
        }
        return arr;

    }
}
