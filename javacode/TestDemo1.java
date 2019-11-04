
class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}//节点类

/**
 * public void addFirst(int data)
 * public void addLast(int data)
 * public void display()
 * public boolean contains(int data)
 * public int getLength()
 *  public ListNode search(int index)
 *  public void addList(int data,int index)
 *   private ListNode searchPre(int key)
 *      private ListNode searchPrev(int key)
 *     public void remove(int key)
 *     public void removeAllKey(int key)
 *     public ListNode reverseList()
 *     public void display2(ListNode newHead)
 *     public ListNode middleNode()
 *     public ListNode findKthToTail(int k)
 */


class MySignalList {//无头结点单项不循环
    public ListNode head;

    public MySignalList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        if (this.head == null) {//插入第一个结点
            ListNode node = new ListNode(data);
            head = node;
        } else {
            //不是第一次插入结点
            ListNode node = new ListNode(data);
            node.next = head;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {//插入第一个结点
            head = node;
        } else {//不是第一次插入结点
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public boolean contains(int data) {
        ListNode p = head;
        while (p != null) {
            if (p.data == data) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public int getLength() {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;

        }
        return length;
    }

    public ListNode search(int index) {
        ListNode n = this.head;
        int i = 0;
        while (i < index) {
            i++;
            n = n.next;
        }
        return n;
    }

    public void addList(int data, int index) {
        if (index < 0 || index > getLength()) {
            System.out.println("插入位置不合法");
        }
        ListNode node = new ListNode(data);
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            ListNode n = search(index-1);
            node.next = n.next;
            n.next = node;
        }

    }




    ////////有问题
//        private ListNode searchPre(int key){
//        ListNode n=head;
//        while(n.next.next!=null&&n.next.data!=key){
//            n=n.next;
//
//        }
//        return n;
//    }


    private ListNode searchPre(int key) {
        ListNode prev = this.head;
        //prev.next  头已经判断了
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }


    public void remove(int key) {
        if (this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }

        //1、找到key的前驱  如果返回空
        ListNode prev = this.searchPre(key);
        if (prev == null) {
            return;
        }
        //2、删除节点
        ListNode del = prev.next;
        prev.next = del.next;
    }

    //删除所有值为key的节点

    ////////      老师说的
//    public void removeAllKey2(int key){
//        ListNode prev = this.head;
//        ListNode cur = this.head.next;
//        while (cur != null) {
//            if(prev.next.data == key){
//                prev.next = cur.next;
//                cur = cur.next;
//            }else {
//                prev = cur;
//                cur = cur.next;
//            }
//        }
//        if(this.head.data == key) {
//            this.head = this.head.next;
//        }
//    }



    ////////         自己写的
    public void removeAllKey1(int key) {


       if(this.head.data==key){
           head=head.next;
           return;
       }
        ListNode pre = this.searchPre(key);
        while (pre != null) {

            if (pre.next.data == key) {
                pre.next = pre.next.next;

            }
            pre = this.searchPre(key);
        }
    }



    public void display1(ListNode head){
        ListNode cur=head;
        while(cur!=null)
        {
            System.out.println(cur.data);
            cur=cur.next;
        }

    }
//    public ListNode reverseList() {
//        ListNode prev = null;
//        ListNode newHead = null;
//        ListNode cur = this.head;
//        while (cur != null) {
//            ListNode curNext = cur.next;
//            if(curNext == null) {
//                newHead = cur;
//            }
//
//            cur.next = prev;
//            prev = cur;
//            cur = curNext;
//        }
//        return newHead;
//    }



    public  ListNode reverseList(){
        ListNode cur=this.head;
        ListNode pre=null;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;

        }
        return newHead;


    }

    public void display2(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //单链表的中间节点
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //返回倒数第k个结点
    public ListNode findKthToTail(int k){
        // k > getLength()
        if(k <= 0) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;//为null
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
    //比x大的构成一个链表  比x小的构成一个链表
    public ListNode partition(int x){
        ListNode cur=this.head;
        ListNode bs=null;//before start
        ListNode be=null;//before end
        ListNode as=null;//after start
        ListNode ae=null;//after end
        while(cur!=null){

            //2.每个结点都可能是尾结点，所以将curNext置为空
//            ListNode curNext=cur.next;
//            curNext=null;
            if(cur.data<x){
                if(bs==null){
                    bs=cur;
                    be=cur;
                }else{
                    be.next=cur;
                    be=be.next;
                }
            }
            if(cur.data>=x){
                if(as==null){
                    as=cur;
                    ae=cur;
                }
                else{
                    ae.next=cur;
                    ae=ae.next;
                }
            }

            //////////////////////注意///////////////////////////
            cur=cur.next;
            //////////////////////注意///////////////////////////

        }

        //before区间为空
        if(bs==null)
        {
            return as;
        }

        //after区间为空

        be.next=as;
        if(as!=null){
            ae.next=null; // 1.尾结点的next为空   1 7 2 3 2 3
        }
        return bs;
    }


    //////前提：有序链表   删除所有重复的值
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if (cur.next != null &&
                    cur.data == cur.next.data) {
                while (cur.next!=null&&cur.data == cur.next.data) {
                    //////cur.next != null
                    cur = cur.next;
                }
                cur = cur.next;
                //tmp.next=cur;
                //1、循环
                //2、退出循环 cur要多走一步
                //
            } else {

                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next=null;/////用例：1 3 3 5 5
        return node.next;

    }
    //回文

    /**
     * 1.找到中间结点
     * 2.将后一半翻转
     * 3.分别从两端比较
     *
     */
    public boolean chkPalindrome() {
        ListNode fast = this.head;
        ListNode slow = this.head;

        //找到中间节点
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //head在左   slow在右
        while(head!=slow){
            if(head.data!=slow.data){
                return false;
            }
            //偶数情况
            if(head.next==slow)
            {
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
    }
public void createLoop(){
        ListNode p=this.head;
        while(p.next!=null){
            p=p.next;
        }
        p.next=this.head.next.next;
}
public boolean hasCycle(){

        return false;
}

public ListNode findNode(){
    ListNode slow=this.head;
    ListNode fast=this.head;
    while( fast!=null&&fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast==slow) {
           break;
        }
    }
    if(fast==null&&fast.next==null){
        //没有环
        return null;
    }
    fast=this.head;
    while(fast!=slow){
        fast=fast.next;
        slow=slow.next;

    }
    return fast;

}

    public  int cycleLength2( ) {

        int count=1;
        ListNode node =this.findNode();
        if(node==null){
            return 0;
        }else{
            ListNode nodeNext=node.next;
            while(nodeNext!=node) {
                nodeNext=nodeNext.next;
                count++;
            }
            return count;
        }
    }

//求环路的长度

}//单链表
public class TestDemo1 {
    //求环路的长度
//    public static int listLength(ListNode head){
//        ListNode slow=head;
//        ListNode fast=head;
//        while(fast!=null&&fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if(slow==fast)
//            {
//                break;
//            }
//        }
//        int count=0;
//        slow=slow.next;
//        while(fast!=slow){
//            fast=fast.next;
//            slow=slow.next;
//            count++;
//
//        }
//        if(fast==null||fast.next==null){
//            return 0;
//        }
//        return count;
//    }
    public static int cycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        fast = fast.next;
        while (fast != slow && fast != null) {
            fast = fast.next;

            count++;

        }
//        if(fast==null||fast.next==null){
//            return 0;
//        }
        return count;
    }


    public static ListNode mergeTwoLists(
            ListNode headA,ListNode headB) {
        ListNode node=new ListNode(-1);
        ListNode temp=node;
        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){

                temp.next=headA;
                headA=headA.next;
                temp=temp.next;
            }
            else{

                temp.next=headB;
                headB=headB.next;
                temp=temp.next;
            }
        }
        if(headA!=null){
            temp.next=headA;
        }
        if(headB!=null){
            temp.next=headB;
        }
        return node.next;
    }


    public static ListNode  getIntersectionNode
            (ListNode headA,ListNode headB){
        if(headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        ListNode pL = headA;
        //永远指向最短的单链表
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        //分别求长度
        while(pL!=null){
            lenA++;
            pL=pL.next;
        }
        while(pS!=null){
            lenB++;
            pS=pS.next;
        }
        //求长度的差值
        int len = lenA-lenB;
        //如果是负数-》pL = headB;  pS = headA
        if(len<0)
        {
            pL=headB;
            pS=headA;
        }
        else
        {
            pS=headB;
            pL=headA;
        }
        while(len!=0){
            pL=pL.next;
            len--; //只需要让pL走len步就好了
        }
        while(pL!=pS&&pL!=null&&pS!=null){ //走完len步之后  两个同时开始走
            // 一直走 走到相同时 就是交点
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pL!=null)
            return pS;
        return null;
    }

    public static void main(String[] args) {
        MySignalList list=new MySignalList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.head.next.next.next.next=list.head.next;
        MySignalList list1=new MySignalList();

        list1.addLast(1);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(8);
//        ListNode n=list.search(3);
//        ListNode p=list1.search(1);
//        n.next=p;
//        ListNode n=mergeTwoLists(list.head,list1.head);
//        list.display2(n);
        //list.createLoop();
//        ListNode n=list.findNode();
//        System.out.println(n.data);
//          ListNode node=getIntersectionNode(list.head,list1.head);
//          System.out.println(node.data);
          System.out.println(list.cycleLength2());
          ListNode s=list.findNode();
        System.out.println(s.data);
//        ListNode head=list.reverseList();
//
//        list.display2(head);

    }

}





