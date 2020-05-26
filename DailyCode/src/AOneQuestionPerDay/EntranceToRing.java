package AOneQuestionPerDay;

import java.util.HashSet;
import java.util.List;

public class EntranceToRing {
    public static class ListNode{
        int val ;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /***
     * 使用HashSet
     */
    private ListNode getEntrance(ListNode head){
        HashSet<ListNode>  set = new HashSet<>();
        while(head != null){
            if(!set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /***
     * 快慢指针法
     * 两指针相遇（此时相交的这一点不是换的入口）
     * 一个指针指向头，两指针再次相交才是入口
     *
     */

    private ListNode getEntrance1(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


}
