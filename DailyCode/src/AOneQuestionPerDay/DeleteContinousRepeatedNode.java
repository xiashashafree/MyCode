package AOneQuestionPerDay;

import java.util.List;

public class DeleteContinousRepeatedNode {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }

        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode cur = newHead;
        while(cur.next!=null && cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                ListNode temp = cur.next;
                while(temp!=null && temp.next!=null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
            }else{
                cur =cur.next;
            }
        }
        return newHead.next;

    }
}
