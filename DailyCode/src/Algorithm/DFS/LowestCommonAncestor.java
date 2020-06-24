package Algorithm.DFS;




import java.util.HashMap;
import java.util.HashSet;

/**
 * 二叉树的最近公共祖先
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class LowestCommonAncestor {

    /** 深搜：存储其结点值与其父节点的引用 **/
    HashMap<Integer, TreeNode> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    private void dfs(TreeNode root){
        if(root.left != null){
            map.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null){
            map.put(root.right.val,root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        dfs(root);
        while(p!=null){
            set.add(p.val);
            p = map.get(p.val);
        }
        while(q!=null){
            if(set.contains(q.val)){
                return q;
            }
            set.add(q.val);
            q= map.get(q.val);
        }
        return null;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int v1 = (l1 == null) ? 0:l1.val;
            int v2 = (l2 == null) ? 0:l2.val;
            int sum = v1+v2;
            if(carry != 0){
                sum+=carry;
            }
            carry = sum/10;

            ListNode node = new ListNode(sum%10);
            cur.next = node;
            cur = cur.next;
            if(l1!= null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(10/10);
    }
}
