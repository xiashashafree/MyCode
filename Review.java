import java.util.HashMap;


class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }

}
class LinkedList{
    Node head;
    public LinkedList(){
        this.head=null;
    }
    /**返回链表长度*/
    public int getLength(){
        Node cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }

    /**头插法*/
    public void addFirst(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        head.next=node;
    }

    /**尾插法*/
    public void addLast(int val){
        Node node=new Node(val);
        if(this.head==null){
            head=node;
            return;
        }
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;

    }

    /**任意位置插入*/
    public void addIndex(int val,int index){
        if(index<0||index>this.getLength()){
            System.out.println("插入位置不合法");
            return;
        }

        if(index==0){
            addFirst(val);
            return;
        }
        if(index==this.getLength()){
            addLast(val);
            return;
        }
        Node cur=head;
        while(index>0){
            index--;
            cur=cur.next;
        }
        Node node=new Node(val);
        node.next=cur.next;
        cur.next=node;


    }

    /**输出数据*/
    public void display(){
        Node cur=head;
        while(cur!=null){

            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }



    public void display1(Node head){
        Node cur=head;
        while(cur!=null){

            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();

    }




    /**返回倒数第k个结点  k从1开始*/
    public Node findKthToTail(int k){

        if(head==null){
            return null;
        }
        Node cur=head;
        while(k>1){

            k--;
            cur=cur.next;
        }

        Node node=head;
        while(cur.next!=null){
            cur=cur.next;
            node=node.next;
        }
        return node;

    }


    public int get(BTNode root){

        if(root.right==null&&root.left==null){
            return 1;
        }
        return get(root.)
    }

    /**返回中间结点*/
    public Node middleNode(){
        if(head==null){
            return  null;
        }
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }

    /**翻转单链表*/
    public Node reverse(){
       Node pre=null;
       Node cur=head;
       Node newHead=null;
       while(cur!=null){
           Node curNext=cur.next;
           if(curNext==null){
               newHead=cur;
           }
           cur.next=pre;
           pre=cur;
           cur=curNext;
       }
       return newHead;

    }
    /**删除重复的连续值 */
    public void removeAllKey() {
        Node node = head;
        Node cur = head;
        while (cur != null) {

            if (cur.val != node.val) {
                node.next = cur;
                node = node.next;
                cur = cur.next;
            } else {
                cur = cur.next;
            }

        }

        if(node!=null){
            //2 1 3(node)  3  要将node.next置为空 否则删除不了最后的3
            node.next=null;
        }

    }

    /**移除未排序链表中的重复节点。保留最开始出现的节点*/
    public void removeDuplicateNodes() {
        Node node = head.next;
        Node cur = head;
        Node pre = cur;
        while (cur != null) {
            node = cur.next;
            pre = cur;
            while (node != null) {
                if (node.val == cur.val) {
                    pre.next = node.next;
                    node = node.next;
                } else {
                    pre = node;
                    node = node.next;
                }
            }
            cur = cur.next;
        }
    }

    /***比x大的在链表前  比x小的在链表链表后*/
    public Node partition(int x) {
        Node big=new Node(-1);
        Node small=new Node(-1);
        Node cur=head;
        Node newHead=big;
        Node nn=small;
        while(cur!=null){
            if(cur.val>=x){
                big.next=cur;
                big=big.next;
                cur=cur.next;
            }else{
                small.next=cur;
                small=small.next;
                cur=cur.next;
            }

        }
        big.next=nn.next;
        small.next=null;
        return newHead.next;

    }

    /**删除倒数第N个结点*/

    public void delete(int k){
        Node fast = this.head;
        Node slow = this.head;
        while (k> 0) {
            if(fast.next != null) {
                fast = fast.next;//为null
                k--;
            }else {
                System.out.println("没有这个节点");
                head=head.next;
                return ;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;



    }

}

public class Review {

    //合并两个有序单列表
    public static Node mergeTwoLists(
            Node headA,Node headB) {
            Node cur=new Node(-1);
            Node newHead=cur;
            while(headA!=null&&headB!=null){
                if(headB.val>headA.val){
                    cur.next=headA;
                    headA=headA.next;
                }else{
                    cur.next=headB;
                    headB=headB.next;
                }
                cur=cur.next;
            }
            if(headA!=null){
                cur.next=headA;
            }
            if(headB!=null){
                cur.next=headB;
            }
            return newHead.next;


    }
    public static void display(Node head){
        while(head!=null){

            System.out.print(head.val);
            head=head.next;
        }

    }
//    public static Node sortList(Node head) {
//
//      if(head==null){
//          return null;
//      }
//
//      Node cur=head;
//        Node n=cur;
//      while(cur!=null){
//
//
//          if(cur.val<n.val){
//              int min=cur.val;
//              cur.val=n.val;
//              n.val=min;
//          }
//         n=cur;
//          cur=cur.next;
//      }
//
//
//        Node fast=head;
//        Node slow=head;
//        while(fast!=null&&fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//        }
//
//
//
//


//    }
    public static  boolean containsNearbyDuplicate(int[] nums, int k){

        HashMap<Integer,Integer> h=new HashMap<>();
        int count=0;
        Boolean flag=false;
        int i = 0;
        for ( ;i < nums.length; i++) {

            if(h.containsKey(nums[i])) {
                flag=true;
                h.put(nums[i], i - h.get(nums[i]));
                break;

            }else{
                flag=false;
                h.put(nums[i],i);
            }



        }
        if(flag &&(h.get(nums[i])<=k)){
            return true;
        }
        return false;

    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {

            h.put(nums[i],h.getOrDefault(nums[i],0)+1);

        }
        for (int i: h.keySet()
             ) {
           if(h.get(i)>(nums.length/2)){
               return i;
           }

        }
        return -1;


    }
    public static void main(String[] args) {

        LinkedList L=new LinkedList();

        L.addLast(1);
        L.addLast(3);
        L.addLast(4);
        L.addLast(5);
        L.display();
        Node node=L.findKthToTail(1);
        System.out.println(node.val);

    }



}
