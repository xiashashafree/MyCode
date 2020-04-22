import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class ListNodeTest {

    /**倒序打印链表*/
    ArrayList<Integer> arr = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arr.add(listNode.val);
        }

        return arr;

    }

    /**返回链表中倒数第N个结点*/
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode first=head;
        ListNode slow=head;
        while(k>1){
            k--;
            first=first.next;
            //此种情况代表：没有倒数第K个结点
            if(first==null){
                return null;
            }
        }
        while(first.next!=null){
            first=first.next;
            slow=slow.next;
        }
        return slow;

    }
}