package AOneQuestionPerDay;
import java.util.*;
public class LinkedAPlusB {



    public static  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

        public ListNode plusAB(ListNode a, ListNode b) {
            ListNode aa = a;
            ListNode bb = b;
            ListNode ret = new ListNode(-1);
            ListNode head = ret;

            int carry = 0;
            while(aa!=null || bb!=null){
                int x = (aa == null)? 0:aa.val;
                int y = (bb == null)? 0:bb.val;

                int sum = x+y+carry;
                carry = sum/10;
                ret.next = new ListNode(sum%10);

                ret = ret.next;
                if(aa!=null){
                    aa = aa.next;
                }
                if(bb != null){
                    bb = bb.next;
                }

            }
            if(carry>0){
                ret.next = new ListNode(carry);

            }
            return head.next;




        }

}
