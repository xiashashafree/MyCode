package Review;

public class ListNodePractice {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = null;
        ListNode cur = slow.next;
        slow.next = null;
        slow = null;
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            if(curNext == null){
                newHead = cur;
                break;
            }
            cur = curNext;
        }
        slow = head;
        fast = newHead;
        while(slow!=null && fast!=null){
            cur = slow.next;//记录原本的next
            slow.next = fast;
            fast = fast.next;
            slow = slow.next;
            slow.next = cur;
            slow = cur;
        }


    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        ListNode end = head;
        int len = 0;
        while(end!=null){
            end = end.next;
            ++len;
        }
        end = head;
        if(k>len){
            k=k%len;
        }
        while(k>0){
            ListNode pre = null;
            end = head;
            while(end.next!=null){
                pre = end;
                end=end.next;
            }
            if(pre!=null){
                pre.next = null;
                end.next = head;
                head = end;

            }
            --k;
        }
        return head;

    }
}
